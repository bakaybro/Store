package com.example.Store.converter;

import com.example.Store.entity.User;
import com.example.Store.entity.UserRole;
import com.example.Store.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<UserModel, User>{
    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToModel);
    }

    private static UserModel convertToModel(User entityToConvert){
        if (entityToConvert == null) return null;
        return UserModel.builder()
                .fullName(entityToConvert.getFullName())
                .login(entityToConvert.getLogin())
                .password(entityToConvert.getPassword())
                .isActive(entityToConvert.getIsActive())
                .userRoleId(entityToConvert.getUserRole().getId())
                .build();
    }

    private static User convertToEntity(UserModel modelToConvert){
        if (modelToConvert == null) return null;

        User userToReturn = new User();

        userToReturn.setFullName(modelToConvert.getFullName());
        userToReturn.setLogin(modelToConvert.getLogin());
        userToReturn.setPassword(modelToConvert.getPassword());
        userToReturn.setIsActive(modelToConvert.getIsActive());
        UserRole userRole = new UserRole();
        userRole.setId(modelToConvert.getUserRoleId());
        userToReturn.setUserRole(userRole);

        return userToReturn;
    }
}
