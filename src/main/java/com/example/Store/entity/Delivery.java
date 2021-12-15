package com.example.Store.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "price_of_delivery")
    private Integer priceOfDelivery;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
