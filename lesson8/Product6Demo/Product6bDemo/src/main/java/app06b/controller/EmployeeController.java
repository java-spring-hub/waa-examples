package app06b.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app06b.domain.Employee;

@org.springframework.stereotype.Controller

public class EmployeeController {
	
	private static final Log logger = LogFactory.getLog(EmployeeController.class);
		
	@RequestMapping(value={"/","employee_input"})
	public String inputEmployee(@ModelAttribute("employee") Employee employee) {
		return "EmployeeForm";
	}

	@RequestMapping(value="/employee_save")
	public String saveEmployee(@Valid @ModelAttribute("employee")  Employee employee, BindingResult bindingResult,
			Model model) {
 		
		if (bindingResult.hasErrors()) {
			return "EmployeeForm";
		}
		
		 String[] suppressedFields = bindingResult.getSuppressedFields();
		 if (suppressedFields.length > 0) {
		 throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
		 + StringUtils.addStringToArray(suppressedFields, ", "));
		 }
		
		
		// save product here
		
	    model.addAttribute("employee", employee);
	    
	   
		return "EmployeeDetails";
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
//         binder.setDisallowedFields("id");
     }
}
