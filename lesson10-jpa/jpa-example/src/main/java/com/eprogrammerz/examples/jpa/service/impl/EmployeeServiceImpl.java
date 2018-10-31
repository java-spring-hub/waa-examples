package com.eprogrammerz.examples.jpa.service.impl;

import com.eprogrammerz.examples.jpa.domain.Employee;
import com.eprogrammerz.examples.jpa.repository.EmployeeRepository;
import com.eprogrammerz.examples.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);

    }

    public Employee get(Long id) {

//		return employeeRepository.findOne(id);
        return employeeRepository.findByName(id);
    }

    ;

    // Populate lazy list
    public Employee getPhones(Long id) {
        Employee employee = this.get(id);
        employee.getPhones().size();

        return employee;
    }

    ;


}
 
