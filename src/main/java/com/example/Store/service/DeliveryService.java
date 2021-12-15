package com.example.Store.service;

import com.example.Store.entity.Delivery;
import com.example.Store.model.DeliveryModel;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(DeliveryModel deliveryModel);
    List<Delivery> getAll();
    Delivery getById(Long id);
    Delivery updateDelivery(Delivery delivery);
    Delivery deleteById(Long id);
}
