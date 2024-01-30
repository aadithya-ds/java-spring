package com.example.employee.Employee.Controller;


import com.example.employee.Employee.DTO.EmployeeDTO;
import com.example.employee.Employee.Entity.Employee;
import com.example.employee.Employee.Repo.EmployeeRepo;
import com.example.employee.Employee.Services.EmpServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
  @Operation(summary = "Add Operation" , description = "Those it creates a new employee in the record")
    public String addEmployee(@RequestBody EmployeeDTO empdto){

      String id = empServices.addEmployee(empdto);

        return id;
    }


   @GetMapping("/getall")

   @Operation(summary = "Get Operation" , description = "Those it retrives all the employee's in the record")
   public List<Employee> getAllEntities() {
     return empServices.getAllEntities();
   }

   @GetMapping("/getEmp/{id}")
   @ApiResponses({
           @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json") }),
           @ApiResponse(responseCode = "404", description = "The Employee  with given Id was not found.", content = { @Content(schema = @Schema()) })
   })
   @Parameter(name = "ID", description = "Employee's ID", required = true)
   @Operation(summary = "Get Operation" , description = "Those it retrives a  employee based on Id in the record")
   public Employee getSingleEmployee(@PathVariable int id){
    return empServices.getSingleEmp(id);
   }

    @GetMapping("/getEmpbyname/{name}")
    @Parameter(name = "Name", description = "Employee's Name", required = true)
    @Operation(summary = "Get Operation" , description = "Those it retrives a  employee based on Name in the record")
    public List<Employee> getEmployeebyname(@PathVariable String name){
        return empServices.getEmployeebyname(name);
    }

    @PutMapping("/update/{id}")
    @Parameter(name = "ID", description = "Employee's ID", required = true)
    @Operation(summary = "Update Operation" , description = "Those it Updates a  employee based on Id in the record")
    public String updateEmployee(@PathVariable int id,@RequestBody EmployeeDTO employeeDTO){
        return empServices.updateEmp(id,employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Parameter(name = "ID", description = "Employee's ID", required = true)
    @Operation(summary = "Delete Operation" , description = "Those it delete a  employee based on Id in the record")
      public String deleteEmployee(@PathVariable int id){
           String ids = empServices.deleteEmp(id);
        return ids;
    }
}
