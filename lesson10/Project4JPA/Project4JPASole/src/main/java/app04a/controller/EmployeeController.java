package app04a.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app04a.domain.Address;
import app04a.domain.Employee;
import app04a.domain.Phone;
import app04a.service.EmployeeService;

@Controller
public class EmployeeController {
 
	@Autowired
	EmployeeService employeeService;
	
	   @RequestMapping(value={"/","/JPAAssociations"}, method = RequestMethod.GET)
	    public String getAssociations() {
	         return "JPAAssociations";
	    }

	   @RequestMapping(value="/OneToManyUniJoinColumn", method = RequestMethod.GET)
	    public ModelAndView doOneToManyUniJoinColumn() {
		   
		   List<Phone> phones = new ArrayList<Phone>();

		   Phone phone = new Phone();
		   phone.setAreaCode(222);
		   phone.setPrefix(333);
		   phone.setNumber(5432);
		   phones.add(phone);

		   phone = new Phone();
		   phone.setAreaCode(111);
		   phone.setPrefix(444);
		   phone.setNumber(2345);
		   phones.add(phone);

		   Employee employee = new Employee();
		   employee.setFirstName("Bill");
		   employee.setLastName("Pay");
		   employee.setSalary(235000);
		   
		   employee.setPhones(phones); 
		   
		   employee =  employeeService.save(employee);
		   
		   // if we do this, we will get an exception because of lazy phones
		   // based on Employee.java setting of LAZY:
		   employee = employeeService.get(employee.getId());
		   // If we do this, it will populate the lazy loaded phones:
//		     employee = employeeService.getPhones(employee.getId());
 	   
		   ModelAndView mav = new ModelAndView();
		   mav.addObject(employee);
		   mav.setViewName("EmployeeDetails");
	         return mav;
	    }

	   @RequestMapping(value="/OneToManyUniJoinTable", method = RequestMethod.GET)
	    public ModelAndView doOneToManyUniJoinTable() {
	
		   
		   // Add First Employee with two addresses
		   Set<Address> addresses = new HashSet<Address>();

		   Address address = new Address();
		   address.setState("New York");;
		   address.setCity("Binghamton");
		   addresses.add(address);

		   address = new Address();
		   address.setState("Rhode Island");;
		   address.setCity("Providence");
		   addresses.add(address);

 		   
		   Employee employee = new Employee();
		   employee.setFirstName("Will");
		   employee.setLastName("KnotPay");
		   employee.setSalary(230000);
		   
		   employee.setAddresses(addresses); 
		   
		   Employee firstEmployee = employeeService.save(employee);
		   
 		   // Add Second with two other addresses
		    addresses = new HashSet<Address>();

		   address = new Address();
		   address.setState("Iowa");;
		   address.setCity("Fairfield");
		   addresses.add(address);

		   address = new Address();
		   address.setState("Mass");;
		   address.setCity("Boston");
		   addresses.add(address);

		   
		   employee = new Employee();
		   employee.setFirstName("Bea");
		   employee.setLastName("Donor");
		   employee.setSalary(500000);

		   // Try for Many-to-Many - add address for first employee to second employee...
//		   List<Address> addressList = new ArrayList<Address>();
		   // Get address from first employee
//		   addressList.addAll(firstEmployee.getAddresses());
//		   addresses.add(addressList.get(0));

		   employee.setAddresses(addresses); 
		   
		   employeeService.save(employee);
		   
		   
		   
		   
		   
		   ModelAndView mav = new ModelAndView();
		   mav.addObject(employee);
		   mav.setViewName("EmployeeDetails");
	         return mav;
	    }

 
	   @RequestMapping(value="/employee", method = RequestMethod.GET)
	    public String inputEmployee() {
	         return "EmployeeForm";
	    }

	    
    @RequestMapping(value="/employee", method = RequestMethod.POST)
    public String saveEmployee(Employee employee ) {
    	
    	employeeService.save(employee);
    	
        return "EmployeeDetails";
    }
    
    
    @RequestMapping(value="/listemployees", method = RequestMethod.GET)
    public String listEmployees(Employee employee, Model model ) {
    	
    	
		List<Employee> list = employeeService.getAll();
		model.addAttribute("employees",  list);
    	
        return "ListEmployees";
    }
    
    
    
}
