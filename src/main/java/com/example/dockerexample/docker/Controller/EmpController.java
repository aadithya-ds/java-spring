package com.example.dockerexample.docker.Controller;



import com.example.dockerexample.docker.DTO.EmployeeDTO;
import com.example.dockerexample.docker.Entity.Employee;
import com.example.dockerexample.docker.Repo.EmployeeRepo;
import com.example.dockerexample.docker.Services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class EmpController {

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
