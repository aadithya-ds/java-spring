package com.CRUD.CRUD_app.Services;

import com.CRUD.CRUD_app.DTO.StudentDTO;
import com.CRUD.CRUD_app.Entity.Student;
import com.CRUD.CRUD_app.Repo.StudentRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIMPL implements  StudentService {

    @Autowired
    StudentRepo studentRepo;


    public String save(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        BeanUtils.copyProperties(studentDTO, student);
        Student savedStudent = studentRepo.save(new Student(studentDTO));
return savedStudent.toString();
    }


    public List<Student> getAllEntities() {
        return studentRepo.findAll();
    }
}
