package fr.dauphine.spring.editor;

import java.beans.PropertyEditorSupport;

import fr.dauphine.spring.bo.Commande;
import fr.dauphine.spring.dao.impl.CommandeDAO;

public class CommandeEditor extends PropertyEditorSupport {
 
    private CommandeDAO commandeService;
 
    public CommandeEditor(CommandeDAO DAO) {
    	commandeService = DAO;
    }
 
    @Override
    public void setAsText(String id) throws IllegalArgumentException {
    	if(id != null){
    		if(!id.equals("0")){
				Commande commande = commandeService.get(id);
		        setValue(commande);
    		}
        	else
        		setValue(null);
    	}
    	else
    		setValue(null);
    }
 
    @Override
    public String getAsText() {
    	Commande commande = (Commande) getValue();
    	String id = super.getAsText();
    	if (commande!=null)
    		id = commande.getId();
        return id;
    }
}
