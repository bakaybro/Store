package com.example.Store.service;

import com.example.Store.entity.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole createUserRole(UserRole userRole);
    List<UserRole> getAll();
    UserRole getById(Long id);
    UserRole updateUserRole(UserRole userRole);
    UserRole deleteById(Long id);
}
