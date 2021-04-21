package com.pharm.repository.productsuggestion;

import com.pharm.model.ProductSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSuggestionRepository extends JpaRepository<ProductSuggestion, Long>, JpaSpecificationExecutor<ProductSuggestion> {
    List<ProductSuggestion> findAll();
}
