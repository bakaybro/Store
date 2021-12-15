package com.example.Store.service.impl;

import com.example.Store.converter.DeliveryConverter;
import com.example.Store.entity.Delivery;
import com.example.Store.exception.ApiFailException;
import com.example.Store.model.DeliveryModel;
import com.example.Store.repository.DeliveryRepository;
import com.example.Store.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryConverter deliveryConverter;

    @Override
    public Delivery createDelivery(DeliveryModel deliveryModel) {
        if (deliveryRepository.findByOrderId(deliveryModel.getOrderId()).isPresent()){
            throw new ApiFailException("Доставка уже оформлена на этот заказ");
        }else return deliveryRepository.save(deliveryConverter.convertFromModel(deliveryModel));
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        Delivery deliveryForUpdate = getById(delivery.getId());

        if (delivery.getCreateDate() != null) deliveryForUpdate.setCreateDate(delivery.getCreateDate());
        if (delivery.getAddress() != null) deliveryForUpdate.setAddress(delivery.getAddress());
        if (delivery.getPhoneNumber() != null) deliveryForUpdate.setPhoneNumber(delivery.getPhoneNumber());
        if (delivery.getPriceOfDelivery() != null) deliveryForUpdate.setPriceOfDelivery(delivery.getPriceOfDelivery());
        if (delivery.getOrder() != null) deliveryForUpdate.setOrder(delivery.getOrder());

        return deliveryRepository.save(deliveryForUpdate);
    }

    @Override
    public Delivery deleteById(Long id) {
        Delivery deliveryForDelete = getById(id);
        if (deliveryForDelete != null) deliveryRepository.delete(deliveryForDelete);

        return deliveryForDelete;
    }
}
