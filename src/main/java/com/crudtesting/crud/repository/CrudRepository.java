package com.crudtesting.crud.repository;

import com.crudtesting.crud.entity.Crud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Crud,Integer> {

    
}
