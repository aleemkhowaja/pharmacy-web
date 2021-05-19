package com.pharm.repository.customer;

import com.pharm.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("select distinct cus from Customer cus "
            + " where (:lastName is null or :lastName= '' or  UPPER(cus.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:cin is null or :cin= '' or  UPPER(cus.cin) like '%'||UPPER(:cin)||'%')  and "
            + " (:cnss is null or :cnss= '' or  UPPER(cus.cnss) like '%'||UPPER(:cnss)||'%')  and "
            + " (:email is null or :email= '' or  UPPER(cus.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(cus.phone) like '%'|| UPPER(:phone)||'%')  and "
            + " (:creditLimit is null or :creditLimit= '' or  UPPER(cus.creditLimit) like '%'|| UPPER(:creditLimit)||'%') and "
            + " (:typeId is null or :typeId= 0l or cus.type.id = :typeId)"
    )
    Page<Customer> filter(@Param("lastName") final String lastName,
                          @Param("cin") final String cin,
                          @Param("cnss") final String cnss,
                          @Param("email") final String email,
                          @Param("phone") final String phone,
                          @Param("creditLimit") final String creditLimit,
                          @Param("typeId") final Long typeId,
                          Pageable pageable);


    @Query("select count(cus) from Customer cus "
            + " where (:lastName is null or :lastName= '' or  UPPER(cus.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:cin is null or :cin= '' or  UPPER(cus.cin) like '%'||UPPER(:cin)||'%')  and "
            + " (:cnss is null or :cnss= '' or  UPPER(cus.cnss) like '%'||UPPER(:cnss)||'%')  and "
            + " (:email is null or :email= '' or  UPPER(cus.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(cus.phone) like '%'|| UPPER(:phone)||'%')  and "
            + " (:creditLimit is null or :creditLimit= '' or  UPPER(cus.creditLimit) like '%'|| UPPER(:creditLimit)||'%') and"
            + " (:typeId is null or :typeId= 0l or cus.type.id = :typeId)"
    )
    long count(@Param("lastName") final String lastName,
               @Param("cin") final String cin,
               @Param("cnss") final String cnss,
               @Param("email") final String email,
               @Param("phone") final String phone,
               @Param("creditLimit") final String creditLimit,
               @Param("typeId") final Long typeId);
}