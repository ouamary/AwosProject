package fr.dauphine.spring.forms;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.bo.Client;

public class AdminForm {

	private Map<BO,Boolean> checkboxes;
	
	public AdminForm(){}
	
	public AdminForm(int nbEntrees){
		checkboxes = new HashMap<BO,Boolean>(nbEntrees);
	}
	
	public AdminForm(List<BO> beans){
		checkboxes = new HashMap<BO,Boolean>(beans.size());
		for(int i = 0; i < beans.size(); i++){
			
			checkboxes.put((BO) beans.get(i), Boolean.TRUE);
			System.out.println("--->" + checkboxes.get(((BO)beans.get(i)).getId()));
		}
	}
	
	public Map<BO,Boolean> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(BO[] values) {
		System.out.println("val = " + values[0]);
		for(BO bean : values)
			this.checkboxes.put(bean, true);
	}
}
