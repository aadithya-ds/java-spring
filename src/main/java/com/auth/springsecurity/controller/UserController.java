package com.auth.springsecurity.controller;

import com.auth.springsecurity.dto.Product;
import com.auth.springsecurity.entity.AuthRequest;
import com.auth.springsecurity.entity.UserInfo;
import com.auth.springsecurity.services.JwtService;
import com.auth.springsecurity.services.UserInfoService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome(){
        return "This is an unsecured endpoint !!";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        return userInfoService.addUser(userInfo);

    }
    @PostMapping("/login")
    public String addUser(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUserName());
        }else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }
    @GetMapping("secured/getUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getAllUsers(){
        return userInfoService.getProducts();
    }

    @GetMapping("secured/getUsers/{id}")
    @RolesAllowed({"USER","ADMIN"})
    public Product getAllUsers(@PathVariable Integer id){

        return userInfoService.getProduct(id);
    }


}