package com.eprogrammerz.examples.jpa.repository;


import com.eprogrammerz.examples.jpa.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("select e from Employee e where e.id = :id")
    Employee findByName(@Param("id") long id);

}

