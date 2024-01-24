package com.CRUD.CRUD_app.Repo;

import com.CRUD.CRUD_app.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
