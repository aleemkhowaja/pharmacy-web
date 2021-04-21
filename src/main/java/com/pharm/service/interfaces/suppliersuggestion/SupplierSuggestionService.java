package com.pharm.service.interfaces.suppliersuggestion;


import com.pharm.model.SupplierSuggestion;
import javassist.NotFoundException;

import java.util.List;

public interface SupplierSuggestionService {

    List<SupplierSuggestion> getAllSupplierSuggestions();
    SupplierSuggestion getSupplierSuggestionById(Long id);

    SupplierSuggestion createSupplierSuggestion(SupplierSuggestion supplierSuggestion);

    SupplierSuggestion updateSupplierSuggestion(SupplierSuggestion supplierSuggestion);

    SupplierSuggestion deleteSupplierSuggestion(SupplierSuggestion supplierSuggestion);
}
