package com.CRUD.CRUD_app.Services;

import com.CRUD.CRUD_app.DTO.StudentDTO;
import com.CRUD.CRUD_app.Entity.Student;

import java.util.List;

public interface StudentService {



    String save(StudentDTO studentsave);

    List<Student> getAllEntities();
}
