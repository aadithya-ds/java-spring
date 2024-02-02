package com.crudtesting.crud.controller;



import com.crudtesting.crud.dto.CrudDto;
import com.crudtesting.crud.entity.Crud;
import com.crudtesting.crud.repository.CrudRepository;
import com.crudtesting.crud.services.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
@Tag(name = "Student",description = "CRUD operation")

public class CrudController {

    @Autowired
    private CrudService crudServices;
    @Autowired
    private CrudRepository crudRepository;

      @PostMapping
      @Operation(summary = "Add Operation" , description = "Those it creates a new Student in the record")
        public String addStudent(@RequestBody CrudDto crudDto){

          return crudServices.saveData(crudDto);
        }


       @GetMapping
       @Operation(summary = "Get Operation" , description = "Those it retrieves all the Student's in the record")
       public List<Crud> getAllEntities() {
         return crudServices.getAllRecords();
       }



       @GetMapping("/{studentId}")
       @ApiResponses({
               @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Crud.class), mediaType = "application/json") }),
               @ApiResponse(responseCode = "404", description = "The Student  with given Id was not found.", content = { @Content(schema = @Schema()) })
       })
//       @Parameter(name = "ID", description = "Student's ID", required = true)
       @Operation(summary = "Get Operation" , description = "Those it retrieves a  Student based on Id in the record")
       public Crud getSingleStudent(@PathVariable int studentId){
        return crudServices.getSingleRecord(studentId);
       }



        @GetMapping("/name/{name}")
        @Operation(summary = "Get Operation" , description = "Those it retrieves a  Student based on Name in the record")
        public List<Crud> getStudentByName(@PathVariable String name){
            return crudServices.getByName(name);
        }


        @PutMapping("/{studentId}")
        @Operation(summary = "Update Operation" , description = "Those it Updates a  Student based on Id in the record")
        public String updateStudent(@PathVariable int studentId,@RequestBody CrudDto crudDto){
            return crudServices.updateData(studentId,crudDto);
        }


        @DeleteMapping("/{studentId}")
        @Operation(summary = "Delete Operation" , description = "Those it delete a  Student based on Id in the record")
          public String deleteStudent(@PathVariable int studentId){
            return crudServices.deleteData(studentId);
        }
}
