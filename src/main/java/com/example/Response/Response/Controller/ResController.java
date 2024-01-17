package com.example.Response.Response.Controller;



import com.example.Response.Response.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Student")
public class ResController {


    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return new ResponseEntity<>("Operation successful!", HttpStatus.OK);
    }

    @GetMapping("/not_found")
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/created")
    public ResponseEntity<String> created(@RequestBody String requestPayload) {

        return new ResponseEntity<>("Resource created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updated")
    public ResponseEntity<String> updated(@RequestBody String requestPayload) {

        return new ResponseEntity<>("Resource updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/deleted")
    public ResponseEntity<String> deleted() {

        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/servererror")
    public ResponseEntity<String> serverError() {

        return new ResponseEntity<>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
