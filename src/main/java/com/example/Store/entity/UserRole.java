package com.example.Store.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseEntity {
    @Column(name = "role_name")
    private String roleName;
}
