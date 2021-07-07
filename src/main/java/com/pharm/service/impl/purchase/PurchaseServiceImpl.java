package com.pharm.service.impl.purchase;

import com.pharm.model.Purchase;
import com.pharm.repository.purchase.PurchaseRepository;
import com.pharm.service.interfaces.purchase.PurchaseService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase findById(Long id) {
        Optional<Purchase> optionalRange = purchaseRepository.findById(id);
        if(optionalRange.isPresent()){
            return optionalRange.get();
        }
        return null;
    }

    @Override
    public Purchase create(Purchase purchase) {
        purchase.setStatus(CommonConstant.ACTIVE);
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase update(Purchase purchase) {
        if (purchase.getId()!=null){
            Purchase persisted = findById(purchase.getId());
            if(persisted==null){
                return null;
            }
            purchase.setStatus(CommonConstant.ACTIVE);
            return purchaseRepository.save(purchase);
        }
        return purchase;
    }

    @Override
    public Purchase delete(Purchase purchase) {
        if (purchase.getId()!=null && purchase!=null){
            Purchase deleted = findById(purchase.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return purchaseRepository.save(deleted);
            }

        }
        return null;
    }

    @Override
    public List<Purchase> findByProductId(Long id) {
        return purchaseRepository.findAllByProductId(id);
    }
}
