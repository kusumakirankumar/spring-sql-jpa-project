package curd.h2.spring.controller;

import curd.h2.spring.entity.User;
import curd.h2.spring.sercvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PostMapping("/addUsers")
    public List<User> createUser(@RequestBody List<User> users){
        return userService.addUsers(users);
    }
    @PutMapping("/user/{id}")
    public User findUser(@PathVariable int id){
        return userService.getUserById(id);
    }
    @PutMapping("/users")
    public List<User> findUsers(){
        return userService.getUsers();
    }
    @GetMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "USER GOT DELETED...";
    }
}
