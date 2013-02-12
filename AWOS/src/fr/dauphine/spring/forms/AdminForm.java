package fr.dauphine.spring.forms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.dauphine.spring.bo.Client;

public class AdminForm {

	private Map<Client,Boolean> checkboxes;
	
	public AdminForm(){}
	
	public AdminForm(int nbEntrees){
		checkboxes = new HashMap<Client,Boolean>(nbEntrees);
	}
	
	public AdminForm(List<Client> clients){
		checkboxes = new HashMap<Client,Boolean>(clients.size());
		for(int i = 0; i < clients.size(); i++){
			
			checkboxes.put(clients.get(i), Boolean.TRUE);
			System.out.println("--->" + checkboxes.get(clients.get(i).getId()));
		}
	}
	
	public Map<Client,Boolean> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(Client[] values) {
		System.out.println("val = " + values[0]);
		for(Client val : values)
			this.checkboxes.put(val, true);
	}
}
