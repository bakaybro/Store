package com.example.Store.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Product extends BaseEntity {
    private String name;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
