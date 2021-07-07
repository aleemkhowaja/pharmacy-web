package com.pharm.controller.delivery;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Delivery;
import com.pharm.model.Product;
import com.pharm.service.interfaces.delivery.DeliveryService;
import com.pharm.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ProductService productService;

    public List<Delivery> getAllDeliveries(){
        return deliveryService.findAll();
    }
    public Delivery getDeliveryById(Long id){
        return deliveryService.findById(id);
    }
    public Delivery createDelivery(Delivery delivery){

        Long id = null;
        if(delivery.getProduct()!=null) {
            id = delivery.getProduct().getId();
        }
        Product product = new Product();
        List<Delivery> deliveries = new ArrayList<>();
        if (id!=null){
            product = productService.findById(id);
            if(product!=null){
                deliveries = deliveryService.findAllByProductId(id);
                delivery.setProduct(product);
                LocalDateTime now = LocalDateTime.now();
                delivery.setCreatedDate(OffsetDateTime.now());
                delivery.setTotal((Double.valueOf(product.getPph()))*(deliveries.size()+1));
                return deliveryService.create(delivery);
            }

        }
        return null;
    }
    public Delivery updateDelivery(Delivery delivery){
        return deliveryService.update(delivery);
    }
    public Delivery deleteDCI(Long id){
        Delivery delivery = new Delivery();
        delivery.setId(id);
        return deliveryService.delete(delivery);
    }
}
