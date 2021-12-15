package com.example.Store.service;

import com.example.Store.entity.User;
import com.example.Store.model.UserAuthModel;
import com.example.Store.model.UserModel;

import java.util.List;

public interface UserService {
    User createUser(UserModel userModel);
    List<User> getAll();
    User getById(Long id);
    User updateClient(User user);
    User deleteById(Long id);
    User getCurrentUser();
    User getByLogin(String login);
    String getBasicAuthHeaderByAuthModel(UserAuthModel userAuthModel);
}
