package fr.dauphine.spring.ctl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.forms.AdminForm;

@Controller
@RequestMapping("helloWorld")
public class HelloWorldController {
	
	//@RequestMapping("/hello")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("hello", "message", "Spring MVC Demo");
	  }

	 // @RequestMapping(value = "/time", method = RequestMethod.GET)
		@RequestMapping(method=RequestMethod.GET)
	  public @ResponseBody String getTime(@RequestParam("name") String name) {
			System.out.println("Nafaefa : "+name);
	    String result = "Time for " + name + " is " + new Date().toString();
	    return result;
	  }

}
