package com.pharm.service.impl.supplier;

import com.pharm.model.Supplier;
import com.pharm.repository.supplier.SupplierRepository;
import com.pharm.service.interfaces.supplier.SupplierService;
import com.pharm.util.CommonConstant;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public List<Supplier> getAllSuppliers(int pageNumber, int pageSize, String sortOrder, String sortBy, Supplier filter) {
        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<Supplier> suppliers = supplierRepository.filter(filter.getLastName(), filter.getEmail(), filter.getPhone(),
                filter.getCity(), filter.getAddress(),PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(suppliers.hasContent())
        {
            final Long size = supplierRepository.count(filter.getLastName(), filter.getEmail(), filter.getPhone(),
                    filter.getCity(), filter.getAddress());
            System.out.println("size::"+size);
            suppliers.getContent().get(0).setCount(size);
        }
        return suppliers.getContent();
    }

    @Override
    @Transactional
    public Supplier getSupplierById(Long id) {
        Optional<Supplier> opt = supplierRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Supplier createSupplier(Supplier supplier) {
        supplier.setStatus(CommonConstant.ACTIVE);
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
            supplier.setStatus(CommonConstant.ACTIVE);
            Supplier updated = supplierRepository.save(supplier);
            return updated;
        }
        return null;
    }

    @Override
    @Transactional
    public Supplier deleteSupplier(Supplier supplier) {
        if(supplier!=null && supplier.getId()!=null){
            Supplier deleted = getSupplierById(supplier.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return supplierRepository.save(deleted);
            }

        }
        return null;
    }
}
