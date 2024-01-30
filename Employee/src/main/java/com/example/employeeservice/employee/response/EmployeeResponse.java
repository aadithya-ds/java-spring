package com.example.employeeservice.employee.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class EmployeeResponse {

    private int id;
    private String name;
    private String email;
    private String age;

    @Autowired
    private AddressResponse addressResponse;



}
