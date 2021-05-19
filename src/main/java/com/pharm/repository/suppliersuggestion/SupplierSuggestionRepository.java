package com.pharm.repository.suppliersuggestion;

import com.pharm.model.SupplierSuggestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierSuggestionRepository extends JpaRepository<SupplierSuggestion,Long> {

    @Query("select distinct sup from SupplierSuggestion sup "
            + " where (:lastName is null or :lastName= '' or  UPPER(sup.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:email is null or :email= '' or  UPPER(sup.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(sup.phone) like '%'|| UPPER(:phone)||'%')  and "
            + " (:city is null or :city= '' or  UPPER(sup.city) like '%'||UPPER(:city)||'%')  and "
            + " (:address is null or :address= '' or  UPPER(sup.address) like '%'|| UPPER(:address)||'%') "
    )
    Page<SupplierSuggestion> filter(@Param("lastName") final String lastName,
                                    @Param("email") final String email,
                                    @Param("phone") final String phone,
                                    @Param("city") final String city,
                                    @Param("address") final String address,
                                    Pageable pageable);


    @Query("select count(sup) from SupplierSuggestion sup "
            + " where (:lastName is null or :lastName= '' or  UPPER(sup.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:email is null or :email= '' or  UPPER(sup.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(sup.phone) like '%'|| UPPER(:phone)||'%')  and "
            + " (:city is null or :city= '' or  UPPER(sup.city) like '%'||UPPER(:city)||'%')  and "
            + " (:address is null or :address= '' or  UPPER(sup.address) like '%'|| UPPER(:address)||'%') "
    )
    long count(@Param("lastName") final String lastName,
               @Param("email") final String email,
               @Param("phone") final String phone,
               @Param("city") final String city,
               @Param("address") final String address);
}