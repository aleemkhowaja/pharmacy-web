package com.pharm.repository.product;

import com.pharm.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select distinct pro from Product pro "
            + " where (:name is null or :name= '' or  UPPER(pro.name) like '%'|| UPPER(:name)||'%') and "
            + " (:barCode is null or :barCode= '' or  UPPER(pro.barCode) like '%'||UPPER(:barCode)||'%')  and "
            + " (:barCode2 is null or :barCode2= '' or  UPPER(pro.barCode2) like '%'||UPPER(:barCode2)||'%')  and "
            + " (:laboratory is null or :laboratory= '' or  UPPER(pro.laboratory) like '%'|| UPPER(:laboratory)||'%')  and "
            + " (:subRange is null or :subRange= '' or  UPPER(pro.subRange) like '%'|| UPPER(:subRange)||'%')  and "
            + " (:productTable is null or :productTable= '' or  UPPER(pro.productTable) like '%'|| UPPER(:productTable)||'%') and "
            + " (:pharmaceuticalFormId is null or :pharmaceuticalFormId= '' or  UPPER(pro.pharmaceuticalForm.id) like '%'|| UPPER(:pharmaceuticalFormId)||'%') and"
            + "(:ppv is null or :ppv= 0.0 or  pro.ppv = (:ppv)) and"
            + "(:dci is null or :dci= 0l or  pro.dci.id = (:dci))"
    )
    Page<Product> filter(@Param("name") final String name,
                         @Param("barCode") final String barCode,
                         @Param("barCode2") final String barCode2,
                         @Param("laboratory") final String laboratory,
                         @Param("subRange") final String subRange,
                         @Param("productTable") final String productTable,
                         @Param("pharmaceuticalFormId") final Long pharmaceuticalFormId,
                         @Param("ppv") final Double ppv,
                         @Param("dci") final Long dciId,
                         Pageable pageable);


    @Query("select count(pro) from Product pro "
            + " where (:name is null or :name= '' or  UPPER(pro.name) like '%'|| UPPER(:name)||'%') and "
            + " (:barCode is null or :barCode= '' or  UPPER(pro.barCode) like '%'||UPPER(:barCode)||'%')  and "
            + " (:barCode2 is null or :barCode2= '' or  UPPER(pro.barCode2) like '%'||UPPER(:barCode2)||'%')  and "
            + " (:laboratory is null or :laboratory= '' or  UPPER(pro.laboratory) like '%'|| UPPER(:laboratory)||'%')  and "
            + " (:subRange is null or :subRange= '' or  UPPER(pro.subRange) like '%'|| UPPER(:subRange)||'%')  and "
            + " (:productTable is null or :productTable= '' or  UPPER(pro.productTable) like '%'|| UPPER(:productTable)||'%') and "
            + " (:pharmaceuticalFormId is null or :pharmaceuticalFormId= '' or  UPPER(pro.pharmaceuticalForm.id) like '%'|| UPPER(:pharmaceuticalFormId)||'%') and"
            + " (:ppv is null or :ppv= 0.0 or  pro.ppv = (:ppv)) and "
            + " (:dci is null or :dci= 0l or  pro.dci.id = (:dci))"
    )
    long count(@Param("name") final String name,
               @Param("barCode") final String barCode,
               @Param("barCode2") final String barCode2,
               @Param("laboratory") final String laboratory,
               @Param("subRange") final String subRange,
               @Param("productTable") final String productTable,
               @Param("pharmaceuticalFormId") final Long pharmaceuticalFormId,
               @Param("ppv") final Double ppv,
               @Param("dci") final Long dciId);
}
