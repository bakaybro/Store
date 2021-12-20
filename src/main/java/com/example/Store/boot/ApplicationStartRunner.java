package com.example.Store.boot;

import com.example.Store.entity.User;
import com.example.Store.entity.UserRole;
import com.example.Store.model.UserModel;
import com.example.Store.service.UserRoleService;
import com.example.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements CommandLineRunner {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        UserRole roleAdmin = new UserRole();
        roleAdmin.setRoleName("ROLE_ADMIN");
        userRoleService.createUserRole(roleAdmin);

        UserRole roleClient = new UserRole();
        roleClient.setRoleName("ROLE_CLIENT");
        userRoleService.createUserRole(roleClient);

        UserModel admin = new UserModel();
        admin.setFullName("Bakai Berdibekov");
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setIsActive(1L);
        admin.setUserRoleId(roleAdmin.getId());
        userService.createUser(admin);

    }
}
