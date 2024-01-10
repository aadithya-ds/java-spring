package com.example.employee.Employee.Controller;


import com.example.employee.Employee.DTO.EmployeeDTO;
import com.example.employee.Employee.Entity.Employee;
import com.example.employee.Employee.Repo.EmployeeRepo;
import com.example.employee.Employee.Services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class EmployeeController {

  @Autowired
  private EmpServices empServices;
@Autowired
private EmployeeRepo employeeRepo;

  @PostMapping("/add")
    public String addEmployee(@RequestBody EmployeeDTO empdto){

      String id = empServices.addEmployee(empdto);

        return id;
    }


   @GetMapping("/getall")
   public List<Employee> getAllEntities() {
     return empServices.getAllEntities();
   }

   @GetMapping("/getEmp/{id}")
   public Employee getSingleEmployee(@PathVariable int id){
    return empServices.getSingleEmp(id);
   }

    @GetMapping("/getEmpbyname/{name}")
    public List<Employee> getEmployeebyname(@PathVariable String name){
        return empServices.getEmployeebyname(name);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        return empServices.updateEmp(id,employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
      public String deleteEmployee(@PathVariable int id){
           String ids = empServices.deleteEmp(id);
        return ids;
    }
}
