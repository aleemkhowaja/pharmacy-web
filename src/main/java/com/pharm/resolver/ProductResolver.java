package com.pharm.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.pharm.model.Delivery;
import com.pharm.model.Product;
import com.pharm.model.Purchase;
import com.pharm.service.interfaces.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductResolver implements GraphQLResolver<Product> {

    @Autowired
    private ProductService productService;

//    public List<Product> getProducts(Provider provider){
//        List<Product> products = new ArrayList<>();
////        for(int i=0;i<provider.getProducts().size();i++) {
////
////            Product product = this.productService.findById(provider.getProducts().get(i).getId());
////            if (product!=null){
////                products.add(product);
////            }
////        }
//        return products;
//
//    }

    public Product getProduct(Purchase purchase){
        return productService.findById(purchase.getProduct().getId());
    }

    public Product getProduct(Delivery delivery){
        return productService.findById(delivery.getProduct().getId());
    }
}
