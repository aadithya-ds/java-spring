package com.crudtesting.crud;

import com.crudtesting.crud.entity.Crud;
import com.crudtesting.crud.repository.CrudRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudOperationTest {

    @Autowired
    private CrudRepository crudRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest() {
        Crud crud = Crud.builder()
                .id(1)
                .name("demo")
                .age(23)
                .build();

        crudRepository.save(crud);

        Optional<Crud> savedCrud = crudRepository.findById(1);
        assertTrue(savedCrud.isPresent());
        assertEquals("demo", savedCrud.get().getName());
        assertEquals(23, savedCrud.get().getAge());
        System.out.println(savedCrud);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getStudentData() {
        Optional<Crud> retrievedCrud = crudRepository.findById(1);
        assertTrue(retrievedCrud.isPresent());
        System.out.println(retrievedCrud);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getAllStudent() {
        List<Crud> allCrud = crudRepository.findAll();
        assertFalse(allCrud.isEmpty());
        System.out.println(allCrud);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateStudent() {
        Crud crud = crudRepository.findById(1).orElseThrow();
        crud.setName("update");
        crudRepository.save(crud);

        Optional<Crud> updatedCrud = crudRepository.findById(1);
        assertTrue(updatedCrud.isPresent());
        assertEquals("update", updatedCrud.get().getName());
        System.out.println(updatedCrud);

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteStudent() {
        crudRepository.deleteById(1);
        Optional<Crud> deletedCrud = crudRepository.findById(1);
        assertFalse(deletedCrud.isPresent());
        System.out.println(deletedCrud);
    }
}
