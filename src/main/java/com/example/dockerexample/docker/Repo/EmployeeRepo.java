package com.example.dockerexample.docker.Repo;


import com.example.dockerexample.docker.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


    List<Employee> findByName(String name);
}
