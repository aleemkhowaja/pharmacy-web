package com.pharm.service.impl.supplier;

import com.pharm.model.Supplier;
import com.pharm.repository.supplier.SupplierRepository;
import com.pharm.service.interfaces.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    @Transactional
    public Supplier getSupplierById(Long id) {
        Optional<Supplier> opt = supplierRepository.findById(id.intValue());
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Supplier createSupplier(Supplier supplier) {
        supplier.setStatus("A");
        return supplierRepository.save(supplier);
    }

    @Override
    @Transactional
    public Supplier updateSupplier(Supplier supplier){
        if (supplier.getId()!= null) {
            Supplier persisted = getSupplierById(supplier.getId());
            if (persisted == null) {
                return null;
            }
            Supplier updated = supplierRepository.save(supplier);
            return updated;
        }
        return null;
    }

    @Override
    @Transactional
    public Supplier deleteSupplier(Supplier supplier) {
        if(supplier!=null && supplier.getId()!=null){
            supplier.setStatus(DELETE);
        }

        return supplierRepository.save(supplier);
    }
}
