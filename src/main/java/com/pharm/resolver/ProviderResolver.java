//package com.pharm.resolver;
//
//import com.coxautodev.graphql.tools.GraphQLResolver;
//import com.pharm.model.Delivery;
//import com.pharm.model.Provider;
//import com.pharm.model.Purchase;
//import com.pharm.service.interfaces.provider.ProviderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProviderResolver implements GraphQLResolver<Provider> {
//    @Autowired
//    private ProviderService providerService;
//
//    public Provider getProvider(Purchase purchase){
//        return providerService.findById(purchase.getProvider().getId());
//    }
//
//    public Provider getProvider(Delivery delivery){
//        return providerService.findById(delivery.getProvider().getId());
//    }
//}
