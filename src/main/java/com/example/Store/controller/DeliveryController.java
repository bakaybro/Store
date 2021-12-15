package com.example.Store.controller;

import com.example.Store.entity.Delivery;
import com.example.Store.model.DeliveryModel;
import com.example.Store.model.ResponseMessage;
import com.example.Store.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAll(){
        return deliveryService.getAll();
    }

    @GetMapping("/{id}")
    public Delivery getById(@PathVariable Long id){
        return deliveryService.getById(id);
    }

    @PostMapping
    public ResponseMessage<Delivery> createDelivery(@RequestBody DeliveryModel deliveryModel){
        return new ResponseMessage<Delivery>().prepareSuccessMessage(deliveryService.createDelivery(deliveryModel));
    }

    @PutMapping
    public Delivery updateDelivery(@RequestBody Delivery delivery){
        return deliveryService.updateDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public Delivery deleteById(@PathVariable Long id){
        return deliveryService.deleteById(id);
    }
}
