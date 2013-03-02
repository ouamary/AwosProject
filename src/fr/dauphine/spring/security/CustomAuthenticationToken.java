package fr.dauphine.spring.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import fr.dauphine.spring.bo.Utilisateur;

@SuppressWarnings("serial")
public class CustomAuthenticationToken implements Authentication {
	
	private Utilisateur user;
	private List<GrantedAuthority> authorithies;
	private Object principal;
	private Object credentials;
	
	public CustomAuthenticationToken(Utilisateur u, Object principal, Object credentials, List<GrantedAuthority> authorithies) {
		super();
		this.user = u;
		this.principal = principal;
		this.credentials = credentials;
		this.authorithies = authorithies;
	}	
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorithies;
	}
	
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		return false;
	}

	@Override
	public void setAuthenticated(boolean arg0) throws IllegalArgumentException {
	}

}
