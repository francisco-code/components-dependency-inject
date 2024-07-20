package com.franciscode.components.services;

import com.franciscode.components.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(OrderEntity orderEntity) {
        return orderEntity.getBasic() - orderEntity.getBasic() * (orderEntity.getDiscount()/100.0) + shippingService.shipment(orderEntity);
    }
}
