package com.example.Store.converter;

import com.example.Store.entity.Order;
import com.example.Store.entity.User;
import com.example.Store.model.OrderModel;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends BaseConverter<OrderModel, Order> {

    public OrderConverter() {
        super(OrderConverter::convertToEntity, OrderConverter::convertToModel);
    }

    private static OrderModel convertToModel(Order entityToConvert){
        if (entityToConvert == null) return null;
        return OrderModel.builder()
                .userId(entityToConvert.getUser().getId())
                .totalSum(entityToConvert.getTotalSum())
                .build();
    }

    private static Order convertToEntity(OrderModel modelToConvert){
        if (modelToConvert == null) return null;

        Order orderToReturn = new Order();

        orderToReturn.setTotalSum(modelToConvert.getTotalSum());
        User user = new User();
        user.setId(modelToConvert.getUserId());
        orderToReturn.setUser(user);

        return orderToReturn;
    }
}
