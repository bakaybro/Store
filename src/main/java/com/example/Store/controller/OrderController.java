package com.example.Store.controller;

import com.example.Store.entity.Order;
import com.example.Store.model.ItemsForBuyModel;
import com.example.Store.model.OrderModel;
import com.example.Store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/get-all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @PostMapping("/save")
    public Order createOrder(@RequestBody OrderModel orderModel){
        return orderService.createOrder(orderModel);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public Order deleteById(@PathVariable Long id){
        return orderService.deleteById(id);
    }

    @PostMapping("/buy")
    public Order buyItems(@RequestBody ItemsForBuyModel itemsForBuyModel) {
        return orderService.buyItems(itemsForBuyModel);
    }
}
