package fr.dauphine.spring.editor;

import java.beans.PropertyEditorSupport;

import fr.dauphine.spring.bo.Produit;
import fr.dauphine.spring.dao.impl.ProduitDAO;

public class ProduitEditor extends PropertyEditorSupport {
 
    private ProduitDAO produitService;
 
    public ProduitEditor(ProduitDAO DAO) {
    	produitService = DAO;
    }
 
    @Override
    public void setAsText(String id) throws IllegalArgumentException {
    	if(id != null){
    		if(!id.equals("0")){
				Produit produit = produitService.get(id);
		        setValue(produit);
    		}
        	else
        		setValue(null);
    	}
    	else
    		setValue(null);
    }
 
    @Override
    public String getAsText() {
    	Produit produit = (Produit) getValue();
    	String id = super.getAsText();
    	if (produit!=null)
    		id = produit.getId();
        return id;
    }
}
