package com.CRUD.CRUD_app.Controller;

import com.CRUD.CRUD_app.DTO.StudentDTO;
import com.CRUD.CRUD_app.Entity.Student;
import com.CRUD.CRUD_app.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String save(@RequestBody StudentDTO studentsave){

        String id = studentService.save(studentsave);
        return id;

    }


    @GetMapping("/getall")
    public List<Student> getAllEntities() {
        return studentService.getAllEntities();
    }




}
