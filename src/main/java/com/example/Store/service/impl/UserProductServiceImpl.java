package com.example.Store.service.impl;

import com.example.Store.converter.UserProductConverter;
import com.example.Store.entity.Product;
import com.example.Store.entity.UserProduct;
import com.example.Store.model.UserProductModel;
import com.example.Store.repository.UserProductRepository;
import com.example.Store.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserProductServiceImpl implements UserProductService {

    @Autowired
    UserProductRepository userProductRepository;

    @Autowired
    private UserProductConverter userProductConverter;


    @Override
    public UserProduct createUserProduct(UserProductModel userProductModel) {
        return userProductRepository.save(userProductConverter.convertFromModel(userProductModel));
    }

    @Override
    public List<UserProduct> getAll() {
        return userProductRepository.findAll();
    }

    @Override
    public UserProduct getById(Long id) {
        return userProductRepository.findById(id).orElse(null);
    }

    @Override
    public UserProduct updateUserProduct(UserProduct userProduct) {
        UserProduct userProductForUpdate = getById(userProduct.getId());

        if (userProduct.getCreateDate() != null) userProductForUpdate.setCreateDate(userProduct.getCreateDate());
        if (userProduct.getUser() != null) userProductForUpdate.setUser(userProduct.getUser());
        if (userProduct.getProduct() != null) userProductForUpdate.setProduct(userProduct.getProduct());
        if (userProduct.getOrder() != null) userProductForUpdate.setOrder(userProduct.getOrder());

        return userProductRepository.save(userProductForUpdate);
    }

    @Override
    public UserProduct deleteById(Long id) {
        UserProduct userProductForDelete = getById(id);
        if (userProductForDelete != null) userProductRepository.delete(userProductForDelete);

        return userProductForDelete;
    }

    @Override
    public List<Product> findUserProductsByOrderId(Long id) {
        return userProductRepository.findUserProductsByOrderId(id).stream().map(x -> x.getProduct()).collect(Collectors.toList());
    }
}
