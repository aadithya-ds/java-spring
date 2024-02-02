package com.crudtesting.crud;


import com.crudtesting.crud.dto.CrudDto;
import com.crudtesting.crud.entity.Crud;
import com.crudtesting.crud.repository.CrudRepository;
import com.crudtesting.crud.services.CrudService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {

    @Autowired
    private CrudService crudService;

    @Autowired
    private CrudRepository crudRepository;



    @Test
    @Order(1)
    @Rollback(value = false)
    public void addDetails(){
        CrudDto testData = CrudDto.builder()
                        .id(1)
                                .age(22)
                                        .name("sample")
                                                .address("tvl").build();



        crudService.saveData(testData);

        Optional<Crud> savedCrud = crudRepository.findById(1);
        Assertions.assertTrue(savedCrud.isPresent());
        Assertions.assertEquals("sample",savedCrud.get().getName());

    }


    @Test
    @Order(2)
    @Rollback(value = false)
    public void updateDataTest() {
        // Given: Setup initial data
        Crud initialData = Crud.builder()
                .name("Initial Name")
                .address("Initial Address")
                .age(22)
                .build();

        crudRepository.save(initialData);

        // When: Perform the update
        CrudDto testData = CrudDto.builder()
                .name("John Updated")
                .build();

        crudService.updateData(1, testData);

        // Then: Verify the updated data
        Optional<Crud> updatedData = crudRepository.findById(1);
        Assertions.assertTrue(updatedData.isPresent());

        // Assertions for the updated name
        Assertions.assertEquals("John Updated", updatedData.get().getName());

        // Assertions for other fields (optional depending on your update logic)
        Assertions.assertEquals("Initial Address", updatedData.get().getAddress());
        Assertions.assertEquals(22, updatedData.get().getAge());
    }


    @Test
    @Order(3)
    @Rollback(value = false)
    public void getData(){
        List<Crud> responseData = crudService.getAllRecords();

        Assertions.assertFalse(responseData.isEmpty());
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void getDataByName(){
        List<Crud> responseData = crudService.getByName("sample");

        Assertions.assertFalse(responseData.isEmpty());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void getById(){
        Crud responseData = crudService.getSingleRecord(1);

        Assertions.assertEquals(1,responseData.getId());
    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteData(){
           String response = crudService.deleteData(1);

        Optional<Crud> responseData = crudRepository.findById(1);
        Assertions.assertTrue(responseData.isEmpty());
    }

}
