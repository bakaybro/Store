package com.example.Store.controller;

import com.example.Store.entity.User;
import com.example.Store.model.ResponseMessage;
import com.example.Store.model.UserAuthModel;
import com.example.Store.model.UserModel;
import com.example.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get-current")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseMessage<User> getById(@PathVariable Long id){
        return new ResponseMessage<User>().prepareSuccessMessage(userService.getById(id));
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody UserModel userModel){
        return userService.createUser(userModel);
    }

    @PostMapping("/sign-in")
    public ResponseMessage<String> getAuthHead(@RequestBody UserAuthModel userAuthModel){
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        String authHeader = userService.getBasicAuthHeaderByAuthModel(userAuthModel);
        return responseMessage.prepareSuccessMessage(authHeader);
    }

    @PutMapping("/update-user")
    public User updateClient(@RequestBody User user){
        return userService.updateClient(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public User deleteById(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
