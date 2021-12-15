package com.example.Store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private String fullName;
    private String login;
    private String password;
    private Long isActive;
    private Long userRoleId;
}
