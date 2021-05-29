package com.pharm.service.interfaces.supplier;


import com.pharm.model.Supplier;

import java.util.List;

public interface SupplierService {
    
    Supplier getSupplierById(final Long id);

    Supplier save(final Supplier supplier);

    Supplier updateSupplier(final Supplier supplier);

    Supplier deleteSupplier(final Supplier supplier);

    List<Supplier> getAllSuppliers(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy, final Supplier filter);
}
