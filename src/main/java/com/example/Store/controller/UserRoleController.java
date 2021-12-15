package com.example.Store.controller;

import com.example.Store.entity.UserRole;
import com.example.Store.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/get-all")
    public List<UserRole> getAll(){
        return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public UserRole getById(@PathVariable Long id){
        return userRoleService.getById(id);
    }

    @PostMapping("/save")
    public UserRole createUserRole(@RequestBody UserRole userRole){
        return userRoleService.createUserRole(userRole);
    }

    @PutMapping("/update")
    public UserRole updateUserRole(@RequestBody UserRole userRole){
        return userRoleService.updateUserRole(userRole);
    }

    @DeleteMapping("/{id}")
    public UserRole deleteById(@PathVariable Long id){
        return userRoleService.deleteById(id);
    }
}
