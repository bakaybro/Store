package com.example.Store.service;

import com.example.Store.entity.Order;
import com.example.Store.model.OrderModel;
import com.example.Store.model.ItemsForBuyModel;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderModel orderModel);
    List<Order> getAll();
    Order getById(Long id);
    Order updateOrder(Order order);
    Order deleteById(Long id);
    Order buyItems(ItemsForBuyModel itemsForBuyModel);
}
