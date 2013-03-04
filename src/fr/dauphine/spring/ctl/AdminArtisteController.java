package fr.dauphine.spring.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.dauphine.spring.bo.Artiste;
import fr.dauphine.spring.dao.impl.ArtisteDAO;
import fr.dauphine.spring.forms.AdminForm;

@Controller
public class AdminArtisteController {

	@Autowired
	private ArtisteDAO DAO;
	
	private PagedListHolder listePagination;
	
	@RequestMapping(value="/admin/artiste", method=RequestMethod.GET)
	public String affichage(ModelMap model) {
		List artistes = DAO.listeArtistes();
		listePagination = new PagedListHolder(artistes);
		listePagination.setPageSize(10);
		model.addAttribute("artistes", listePagination);
		model.addAttribute("adminForm", new AdminForm(artistes));
		return "./bo/adminArtiste";
	}
	
	@RequestMapping(value="/admin/artiste/{page}", method=RequestMethod.GET)
	public String affichagePage(@PathVariable(value="page") String page, ModelMap model) {
		List artistes = DAO.listeArtistes();
		listePagination = new PagedListHolder(artistes);
		listePagination.setPageSize(10);
		listePagination.setPage(Integer.parseInt(page)-1);
		model.addAttribute("artistes", listePagination);
		model.addAttribute("adminForm", new AdminForm(artistes));
		return "./bo/adminArtiste";
	}
		
	@RequestMapping(value="/admin/artiste", method=RequestMethod.POST) 
	public String suppression(@RequestParam(value="checkboxes") String[] checkboxes, @ModelAttribute("adminForm") AdminForm admin, BindingResult result) throws Exception {
		
		List<Artiste> artistes = DAO.get();
		Artiste a;
		int j =0;

		System.out.println(" --CBE->" + checkboxes);
		
		for(int i = 0; (i < artistes.size()) && (j < checkboxes.length); i++){
			a = artistes.get(i);
			if(a.getId().equals(checkboxes[j])){
				j++;
				a.setDeleted(true);
				DAO.save(a);
				System.out.println(a + " ");
			}
		}
		
		return "redirect:/bo/action/admin/artiste";
    }
}