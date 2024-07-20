package com.franciscode.components.services;

import com.franciscode.components.entities.OrderEntity;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(OrderEntity orderEntity) {
        if (orderEntity.getBasic() < 100.0) {
            return 20.0;
        } else if (orderEntity.getBasic() <= 200.0) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}
