package com.pharm.service.interfaces.purchase;

import com.pharm.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseService {
    List<Purchase> findAll();
    Purchase findById(Long id);
    Purchase create(Purchase purchase);
    Purchase update(Purchase purchase);
    Purchase delete(Purchase purchase);

    List<Purchase> findByProductId(Long id);
}
