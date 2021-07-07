package com.pharm.controller.purchase;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Product;
import com.pharm.model.Purchase;
import com.pharm.service.interfaces.purchase.PurchaseService;
import com.pharm.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;

    public List<Purchase> getAllPurchases(){
        return purchaseService.findAll();
    }

    public Purchase createPurchase(Purchase purchase){
        Long id = null;
        if(purchase.getProduct()!=null) {
            id = purchase.getProduct().getId();
        }
        Product product = new Product();
        List<Purchase> purchases = new ArrayList<>();
        if (id!=null){
            product = productService.findById(id);
            if(product!=null){
                purchases = purchaseService.findByProductId(id);
                purchase.setProduct(product);
                purchase.setCould(product.getPph());
                LocalDateTime now = LocalDateTime.now();
                purchase.setCreatedDate(OffsetDateTime.now());
                purchase.setTotal((Double.valueOf(product.getPph()))*(purchases.size()+1));
                return purchaseService.create(purchase);
            }

        }
        return null;
    }
}
