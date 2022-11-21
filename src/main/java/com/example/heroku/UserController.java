package com.example.heroku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RequestMapping("/api/v1/")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("test")
    public String test(){
        return "All Ok";
    }
    @GetMapping
    public List<User> findAll(){
        return userService.getAll();
    }
    @PostMapping
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }
    @DeleteMapping
    public void delete(@RequestParam String id){
        userService.deleteUser(id);
    }
    @PutMapping
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }
}
