package com.example.Store.controller;

import com.example.Store.entity.Product;
import com.example.Store.entity.UserProduct;
import com.example.Store.model.UserProductModel;
import com.example.Store.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-product")
public class UserProductController {
    @Autowired
    private UserProductService userProductService;

    @GetMapping("/get-all")
    public List<UserProduct> getAll(){
        return userProductService.getAll();
    }

    @GetMapping("/{id}")
    public UserProduct getById(@PathVariable Long id){
        return userProductService.getById(id);
    }

    @GetMapping("/order/{id}")
    public List<Product> findUserProductsByOrderId (@PathVariable Long id){
        return userProductService.findUserProductsByOrderId(id);
    }

    @PostMapping("/save")
    public UserProduct createUserProduct(@RequestBody UserProductModel userProductModel){
        return userProductService.createUserProduct(userProductModel);
    }

    @PutMapping("/update")
    public UserProduct updateUserProduct(@RequestBody UserProduct userProduct){
        return userProductService.updateUserProduct(userProduct);
    }

    @DeleteMapping("/{id}")
    public UserProduct deleteById(@PathVariable Long id){
        return userProductService.deleteById(id);
    }
}
