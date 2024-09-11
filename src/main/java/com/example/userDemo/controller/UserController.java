package com.example.userDemo.controller;


import com.example.userDemo.Entity.User;
import com.example.userDemo.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
     IUserService userService;

     @GetMapping("/all")
     public List<User> getAllUsers(){
        return userService.getAllUsers();
     }

     @GetMapping("/getUser")
     public Optional<User> getUser(@Valid @RequestParam Integer id)
     {
        return userService.getUserById(id);
     }

     @PostMapping("/addUser")
     public String addUser(@Valid @RequestBody User user)
     {
         return userService.addUser(user);
     }

     @DeleteMapping("/deleteUser/{id1}")
     public String deleteUser(@Valid @PathVariable("id1") Integer id)
     {
          return userService.deleteUser(id);
     }
}


