package com.example.Store.service.impl;

import com.example.Store.converter.ProductConverter;
import com.example.Store.entity.Product;
import com.example.Store.model.ProductModel;
import com.example.Store.repository.ProductRepository;
import com.example.Store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public Product createProduct(ProductModel productModel) {
        return productRepository.save(productConverter.convertFromModel(productModel));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productForUpdate = getById(product.getId());

        if (product.getCreateDate() != null) productForUpdate.setCreateDate(product.getCreateDate());
        if (product.getName() != null) productForUpdate.setName(product.getName());
        if (product.getPrice() != null) productForUpdate.setPrice(product.getPrice());
        if (product.getImage() != null) productForUpdate.setImage(product.getImage());

        return productRepository.save(productForUpdate);
    }

    @Override
    public Product deleteById(Long id) {
        Product productForDelete = getById(id);
        if (productForDelete != null) productRepository.delete(productForDelete);

        return productForDelete;
    }
}
