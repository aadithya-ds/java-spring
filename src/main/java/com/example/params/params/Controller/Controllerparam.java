package com.example.params.params.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Slf4j
@CrossOrigin
public class Controllerparam {

    @GetMapping("/getData")
    public String getdata(@RequestHeader("User-Agent") String userAgent){
        return  "User-Agent : "+userAgent+".";

    }

    @GetMapping("/getParam")
    public String param(@RequestParam("name") String name){
        return "Name : "+name+".";
    }

    @GetMapping("/request_header")
    public String handleCustomHeader(
            @RequestHeader("Req") String customHeaderValue) {

        return "Value of Custom-Header: " + customHeaderValue;
    }



}
