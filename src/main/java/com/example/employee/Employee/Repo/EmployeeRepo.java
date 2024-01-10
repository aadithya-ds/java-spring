package com.example.employee.Employee.Repo;

import com.example.employee.Employee.DTO.EmployeeDTO;
import com.example.employee.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


    List<Employee> findByName(String name);
}
