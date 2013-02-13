package fr.dauphine.spring.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.dao.impl.CategorieDAO;

public class CategorieEditor extends PropertyEditorSupport {
 
    private CategorieDAO categorieService;
 
    public CategorieEditor(CategorieDAO DAO) {
    	categorieService = DAO;
    }
 
    @Override
    public void setAsText(String id) throws IllegalArgumentException {
    	if(id != null){
    		if(!id.equals("0")){
				Categorie categorie = categorieService.get(id);
		        setValue(categorie);
    		}
        	else
        		setValue(null);
    	}
    	else
    		setValue(null);
    }
 
    @Override
    public String getAsText() {
    	Categorie categorie = (Categorie) getValue();
    	String id = super.getAsText();
    	if (categorie!=null)
    		id = categorie.getId();
        return id;
    }
}
