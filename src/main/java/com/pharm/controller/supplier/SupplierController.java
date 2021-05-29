package com.pharm.controller.supplier;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Supplier;
import com.pharm.service.interfaces.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private SupplierService supplierService;

    public List<Supplier> getAllSuppliers(
            final int pageNumber,
            final int pageSize,
            final String sortOrder,
            final String sortBy,
            final Supplier filter
    ){
        return supplierService.getAllSuppliers(pageNumber, pageSize, sortOrder, sortBy, filter);
    }

    public Supplier getSupplier(Long id){
        return supplierService.getSupplierById(id);
    }

    public Supplier save(Supplier supplier){
        return supplierService.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        supplier.setId(id);
        return supplierService.updateSupplier(supplier);
    }
    public Supplier deleteSupplier(Long id){
        Supplier supplier = new Supplier();
        supplier.setId(id);
        return supplierService.deleteSupplier(supplier);
    }
}
