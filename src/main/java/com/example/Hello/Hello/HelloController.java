package com.example.Hello.Hello;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class HelloController {

    @GetMapping("/hello")
    public  String getHello(){
        return "HelloWorld";
    }


}
