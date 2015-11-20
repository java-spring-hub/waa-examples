package app04a.service;

import java.util.List;

import app04a.domain.Employee;

 public interface EmployeeService   {
	
	public List<Employee> getAll();
	
	public Employee save(Employee employee);
	
	public Employee get(Long id);

	public Employee getPhones(Long id);

}
 
