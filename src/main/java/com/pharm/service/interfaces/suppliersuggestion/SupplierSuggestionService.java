package com.pharm.service.interfaces.suppliersuggestion;


import com.pharm.model.SupplierSuggestion;

import java.util.List;

public interface SupplierSuggestionService {

    List<SupplierSuggestion> getAllSupplierSuggestions(int pageNumber, int pageSize, String sortOrder, String sortBy, SupplierSuggestion filter);
    SupplierSuggestion getSupplierSuggestionById(Long id);

    SupplierSuggestion createSupplierSuggestion(SupplierSuggestion supplierSuggestion);

    SupplierSuggestion updateSupplierSuggestion(SupplierSuggestion supplierSuggestion);

    SupplierSuggestion deleteSupplierSuggestion(SupplierSuggestion supplierSuggestion);
}
