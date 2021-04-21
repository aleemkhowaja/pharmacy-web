package com.pharm.repository.suppliersuggestion;

import com.pharm.model.SupplierSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierSuggestionRepository extends JpaRepository<SupplierSuggestion,Integer> {
}
