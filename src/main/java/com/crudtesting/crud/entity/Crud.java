package com.crudtesting.crud.entity;


import com.crudtesting.crud.dto.CrudDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Crud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    @Schema(description = "Student's Age", example = "22")
    private int age;

    @Column(name = "name")
    @Schema(description = "Student's Name", example = "Adam")
    private String name;

    @Column(name = "address")
    @Schema(description = "Student's Address", example = "California")
    private String address;




    public Crud(){

    }

    public Crud(CrudDto crudDto) {
        this.age = crudDto.getAge();
        this.name = crudDto.getName();
        this.address = crudDto.getAddress();
    }


}
