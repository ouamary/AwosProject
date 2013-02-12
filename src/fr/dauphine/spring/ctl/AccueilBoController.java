package fr.dauphine.spring.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dauphine.spring.dao.impl.ItemDAO;

@Controller
@RequestMapping("accueilBO")
public class AccueilBoController {
	
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody String[] chargerElements(){
		List<String> list = itemDAO.listeElements();
		System.out.println("==>"+list.get(0).toString()+" de type "+list.get(0).getClass());
		String[] elements = new String[list.size()];
		elements = list.toArray(elements);
		//*
		for(int i = 0; i < list.size(); i++){
			System.out.println("==>"+elements[i]);
			//elements[i] = (String) list.get(i).toString(); 
		}//*/
		return elements;//*/
	}
}
