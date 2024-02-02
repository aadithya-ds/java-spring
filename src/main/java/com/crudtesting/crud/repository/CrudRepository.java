package com.crudtesting.crud.repository;

import com.crudtesting.crud.entity.Crud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrudRepository extends JpaRepository<Crud,Integer> {


    List<Crud> findByName(String name);
}
