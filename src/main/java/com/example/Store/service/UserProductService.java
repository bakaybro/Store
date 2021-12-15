package com.example.Store.service;

import com.example.Store.entity.Product;
import com.example.Store.entity.UserProduct;
import com.example.Store.model.UserProductModel;

import java.util.List;

public interface UserProductService {
    UserProduct createUserProduct(UserProductModel userProductModel);
    List<UserProduct> getAll();
    UserProduct getById(Long id);
    UserProduct updateUserProduct(UserProduct userProduct);
    UserProduct deleteById(Long id);
    List<Product> findUserProductsByOrderId(Long id);
}
