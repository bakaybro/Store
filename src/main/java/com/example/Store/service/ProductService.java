package com.example.Store.service;

import com.example.Store.entity.Product;
import com.example.Store.model.ProductModel;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductModel productModel);
    List<Product> getAll();
    Product getById(Long id);
    Product updateProduct(Product product);
    Product deleteById(Long id);
}
