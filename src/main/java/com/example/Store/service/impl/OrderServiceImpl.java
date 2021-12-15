package com.example.Store.service.impl;

import com.example.Store.converter.OrderConverter;
import com.example.Store.converter.UserProductConverter;
import com.example.Store.entity.Order;
import com.example.Store.entity.Product;
import com.example.Store.entity.User;
import com.example.Store.entity.UserProduct;
import com.example.Store.model.ItemsForBuyModel;
import com.example.Store.model.OrderModel;
import com.example.Store.repository.OrderRepository;
import com.example.Store.service.OrderService;
import com.example.Store.service.UserProductService;
import com.example.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserProductService userProductService;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private UserProductConverter userProductConverter;

    @Autowired
    private UserService userService;

    @Override
    public Order createOrder(OrderModel orderModel) {
        return orderRepository.save(orderConverter.convertFromModel(orderModel));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        Order orderForUpdate = getById(order.getId());

        if (order.getCreateDate() != null) orderForUpdate.setCreateDate(order.getCreateDate());
        if (order.getUser() != null) orderForUpdate.setUser(order.getUser());
        if (order.getTotalSum() != null) orderForUpdate.setTotalSum(order.getTotalSum());

        return orderRepository.save(orderForUpdate);
    }

    @Override
    public Order deleteById(Long id) {
        Order orderForDelete = getById(id);
        if (orderForDelete != null) orderRepository.delete(orderForDelete);

        return orderForDelete;
    }

    @Override
    public Order buyItems(ItemsForBuyModel itemsForBuyModel) {
        Order order = new Order();
        order.setTotalSum(0.0);

        User user = userService.getById(itemsForBuyModel.getUserId());//получить по userId
        order.setUser(user);

        for(Product product : itemsForBuyModel.getProductList()) {
            order.setTotalSum(order.getTotalSum() + product.getPrice());
        }
        orderRepository.save(order);

        for(Product product : itemsForBuyModel.getProductList()) {
            UserProduct userProduct = new UserProduct();

            userProduct.setProduct(product);
            userProduct.setUser(user);
            userProduct.setOrder(order);

            userProductService.createUserProduct(userProductConverter.convertFromEntity(userProduct));
        }

//        считаем сумму for each product in products
//        orderService.save(order) -- сохранили order и теперь знаем его ID
//        опять проходимся по продуктам и сохраняем в таблицу user_products, userId, product.getId, order.getId

        return order;
    }
}
