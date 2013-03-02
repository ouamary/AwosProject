package fr.dauphine.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.dao.impl.UtilisateurDAO;

@SuppressWarnings("serial")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UtilisateurDAO uDAO;
		
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String principal = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		final Utilisateur u = uDAO.findUtilisateur(principal);

		if (u != null && uDAO.checkPassword(u, password)) {

			final GrantedAuthority gai = new GrantedAuthority() {
			
				public String getAuthority() {
					return u.getRole();
				}
			};
			
			List<GrantedAuthority> authorithies = new ArrayList<GrantedAuthority>();
			authorithies.add(gai);
			//return new UsernamePasswordAuthenticationToken(principal, password, authorithies);
			return new CustomAuthenticationToken(u, principal, password, authorithies);
			

		}
		throw new BadCredentialsException("Mauvaise authentification : "
				+ principal);
	}

	public boolean supports(Class aClass) {
		return true;
	}
}
