package com.example.employee.Employee.Entity;


import com.example.employee.Employee.DTO.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

@Data

@AllArgsConstructor
@Entity
@Table(name = "employeedetails")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;


    public Employee(EmployeeDTO empdto) {

        this.age = empdto.getAge();
        this.name = empdto.getName();
        this.address = empdto.getAddress();

    }

    public Employee(int id, int age, String name, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public Employee(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
