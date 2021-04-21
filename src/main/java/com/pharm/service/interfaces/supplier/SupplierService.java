package com.pharm.service.interfaces.supplier;


import com.pharm.model.Supplier;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(Long id);

    Supplier createSupplier(Supplier supplier);

    Supplier updateSupplier(Supplier supplier);

    Supplier deleteSupplier(Supplier supplier);
}
