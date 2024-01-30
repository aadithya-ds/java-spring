package com.example.employee.Employee.Controller;


import com.example.employee.Employee.DTO.EmployeeDTO;
import com.example.employee.Employee.Entity.Employee;
import com.example.employee.Employee.Repo.EmployeeRepo;
import com.example.employee.Employee.Services.EmpServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
@Tag(name = "Employee",description = "CRUD operation")

public class EmployeeController {

  @Autowired
  private EmpServices empServices;
@Autowired
private EmployeeRepo employeeRepo;

  @PostMapping("/add")
  @Operation(summary = "Add Operation" , description = "This it creates a new employee in the record")
    public String addEmployee(@RequestBody EmployeeDTO empdto){

      String id = empServices.addEmployee(empdto);

        return id;
    }


   @GetMapping("/getall")
   @Operation(summary = "Get Operation" , description = "This it retrives all the employee's in the record")
   public List<Employee> getAllEntities() {
     return empServices.getAllEntities();
   }

   @GetMapping("/getEmp/{id}")
   @Operation(summary = "Get Operation" , description = "This it retrives a  employee based on Id in the record")
   public Employee getSingleEmployee(@PathVariable int id){
    return empServices.getSingleEmp(id);
   }

    @GetMapping("/getEmpbyname/{name}")
    @Operation(summary = "Get Operation" , description = "This it retrives a  employee based on Name in the record")
    public List<Employee> getEmployeebyname(@PathVariable String name){
        return empServices.getEmployeebyname(name);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update Operation" , description = "This it Updates a  employee based on Id in the record")
    public String updateEmployee(@PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        return empServices.updateEmp(id,employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Operation" , description = "This it delete a  employee based on Id in the record")
      public String deleteEmployee(@PathVariable int id){
           String ids = empServices.deleteEmp(id);
        return ids;
    }
}
