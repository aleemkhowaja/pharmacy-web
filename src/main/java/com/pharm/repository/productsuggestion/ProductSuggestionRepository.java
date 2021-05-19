package com.pharm.repository.productsuggestion;

import com.pharm.model.ProductSuggestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductSuggestionRepository extends JpaRepository<ProductSuggestion, Long>, JpaSpecificationExecutor<ProductSuggestion> {
    @Query("select distinct pro from ProductSuggestion pro "
            + " where (:lastName is null or :lastName= '' or  UPPER(pro.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:barCode is null or :barCode= '' or  UPPER(pro.barCode) like '%'||UPPER(:barCode)||'%')  and "
            + " (:barCode2 is null or :barCode2= '' or  UPPER(pro.barCode2) like '%'||UPPER(:barCode2)||'%')  and "
            + " (:laboratory is null or :laboratory= '' or  UPPER(pro.laboratory) like '%'|| UPPER(:laboratory)||'%')  and "
            + " (:subRange is null or :subRange= '' or  UPPER(pro.subRange) like '%'|| UPPER(:subRange)||'%')  and "
            + " (:productTable is null or :productTable= '' or  UPPER(pro.productTable) like '%'|| UPPER(:productTable)||'%') "
    )
    Page<ProductSuggestion> filter(@Param("lastName") final String lastName,
                                   @Param("barCode") final String barCode,
                                   @Param("barCode2") final String barCode2,
                                   @Param("laboratory") final String laboratory,
                                   @Param("subRange") final String subRange,
                                   @Param("productTable") final String productTable,
                                   Pageable pageable);


    @Query("select count(pro) from ProductSuggestion pro "
            + " where (:lastName is null or :lastName= '' or  UPPER(pro.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:barCode is null or :barCode= '' or  UPPER(pro.barCode) like '%'||UPPER(:barCode)||'%')  and "
            + " (:barCode2 is null or :barCode2= '' or  UPPER(pro.barCode2) like '%'||UPPER(:barCode2)||'%')  and "
            + " (:laboratory is null or :laboratory= '' or  UPPER(pro.laboratory) like '%'|| UPPER(:laboratory)||'%')  and "
            + " (:subRange is null or :subRange= '' or  UPPER(pro.subRange) like '%'|| UPPER(:subRange)||'%')  and "
            + " (:productTable is null or :productTable= '' or  UPPER(pro.productTable) like '%'|| UPPER(:productTable)||'%') "
    )
    long count(@Param("lastName") final String lastName,
               @Param("barCode") final String barCode,
               @Param("barCode2") final String barCode2,
               @Param("laboratory") final String laboratory,
               @Param("subRange") final String subRange,
               @Param("productTable") final String productTable);
}
