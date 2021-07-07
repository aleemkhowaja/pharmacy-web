package com.pharm.repository.delivery;

import com.pharm.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    List<Delivery> findAll();
    List<Delivery> findAllByProductId(Long id);
}
