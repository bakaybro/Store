package com.example.Store.converter;

import com.example.Store.entity.Order;
import com.example.Store.entity.Product;
import com.example.Store.entity.User;
import com.example.Store.entity.UserProduct;
import com.example.Store.model.UserProductModel;
import org.springframework.stereotype.Component;

@Component
public class UserProductConverter extends BaseConverter<UserProductModel, UserProduct>{
    public UserProductConverter() {
        super(UserProductConverter::convertToEntity, UserProductConverter::convertToModel);
    }

    private static UserProductModel convertToModel(UserProduct entityToConvert){
        if (entityToConvert == null) return null;
        return UserProductModel.builder()
                .userId(entityToConvert.getUser().getId())
                .productId(entityToConvert.getProduct().getId())
                .orderId(entityToConvert.getOrder().getId())
                .build();
    }

    private static UserProduct convertToEntity(UserProductModel modelToConvert){
        if (modelToConvert == null) return null;

        UserProduct userProductToReturn = new UserProduct();

        User user = new User();
        user.setId(modelToConvert.getUserId());
        userProductToReturn.setUser(user);
        Product product = new Product();
        product.setId(modelToConvert.getProductId());
        userProductToReturn.setProduct(product);
        Order order = new Order();
        order.setId(modelToConvert.getOrderId());
        userProductToReturn.setOrder(order);

        return userProductToReturn;
    }
}
