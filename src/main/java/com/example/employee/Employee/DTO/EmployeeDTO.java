package com.example.employee.Employee.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;



@Data




public class EmployeeDTO {



    private int id;

    @Schema(description = "Employee's Age", example = "22")
    private int age;

    @Schema(description = "Employee's Name", example = "Adam")
    private String name;

    @Schema(description = "Employee's Address", example = "California")
    private String address;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, int age, String name, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }
}
