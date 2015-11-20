package app04a.service;

import java.util.List;

import app04a.domain.Employee;
import app04a.domain.Phone;

 public interface PhoneService   {
	
	public List<Phone> getAll();
	
	public Phone save(Phone phone);
	
	
		   
}
 
