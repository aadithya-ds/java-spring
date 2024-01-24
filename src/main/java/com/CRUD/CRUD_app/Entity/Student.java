package com.CRUD.CRUD_app.Entity;


import com.CRUD.CRUD_app.DTO.StudentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studentdetails")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="roll")
    private int rollno;
    @Column(name="name")
    private String name;
    @Column(name="department")
    private String department;

    public Student(StudentDTO studentDTO) {
        this.name = studentDTO.getName();
        this.department = studentDTO.getDepartment();
    }
}
