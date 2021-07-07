package com.pharm.service.interfaces.delivery;

import com.pharm.model.Delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> findAll();
    Delivery findById(Long id);
    Delivery create(Delivery delivery);
    Delivery update(Delivery  delivery);
    Delivery delete(Delivery delivery);
    List<Delivery> findAllByProductId(Long id);
}
