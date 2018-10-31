package com.eprogrammerz.examples.jpa.service;

import com.eprogrammerz.examples.jpa.domain.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public Employee save(Employee employee);

    public Employee get(Long id);

    public Employee getPhones(Long id);

}
 
