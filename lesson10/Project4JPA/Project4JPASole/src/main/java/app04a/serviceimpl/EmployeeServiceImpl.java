package app04a.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app04a.domain.Employee;
import app04a.domain.Phone;
import app04a.repository.EmployeeRepository;
import app04a.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
  	public List<Employee> getAll() {
		return  (List<Employee>) employeeRepository.findAll();
	}
	
	public Employee  save(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	
	public Employee get(Long id) {
		
//		return employeeRepository.findOne(id);
		return employeeRepository.findByName(id);
	};
	
	// Populate lazy list
	public Employee getPhones(Long id) {
		Employee employee = this.get(id);
		employee.getPhones().size();
  
		return employee;
	};
	
		   
}
 
