package fr.dauphine.spring.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import fr.dauphine.spring.bo.Categorie;
import fr.dauphine.spring.bo.Client;
import fr.dauphine.spring.dao.impl.CategorieDAO;
import fr.dauphine.spring.dao.impl.ClientDAO;

public class ClientEditor extends PropertyEditorSupport {
 
    private ClientDAO clientService;
 
    public ClientEditor(ClientDAO DAO) {
    	clientService = DAO;
    }
 
    @Override
    public void setAsText(String id) throws IllegalArgumentException {
    	if(id != null){
    		if(!id.equals("0")){
				Client client = clientService.get(id);
		        setValue(client);
    		}
        	else
        		setValue(null);
    	}
    	else
    		setValue(null);
    }
 
    @Override
    public String getAsText() {
    	Client client = (Client) getValue();
    	String id = super.getAsText();
    	if (client!=null)
    		id = client.getId();
        return id;
    }
}
