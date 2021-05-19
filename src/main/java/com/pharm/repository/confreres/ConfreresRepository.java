package com.pharm.repository.confreres;

import com.pharm.model.Confreres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfreresRepository extends JpaRepository<Confreres, Long> {

    @Query("select distinct con from Confreres con "
            + " where (:lastName is null or :lastName= '' or  UPPER(con.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:cin is null or :cin= '' or  UPPER(con.cin) like '%'||UPPER(:cin)||'%')  and "
            + " (:cnss is null or :cnss= '' or  UPPER(con.cnss) like '%'||UPPER(:cnss)||'%')  and "
            + " (:email is null or :email= '' or  UPPER(con.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(con.phone) like '%'|| UPPER(:phone)||'%')  and "
            + " (:address is null or :address= '' or  UPPER(con.address) like '%'|| UPPER(:address)||'%') "
    )
    Page<Confreres> filter(@Param("lastName") final String lastName,
                           @Param("cin") final String cin,
                           @Param("cnss") final String cnss,
                           @Param("email") final String email,
                           @Param("phone") final String phone,
                           @Param("address") final String address,
                           Pageable pageable);


    @Query("select count(con) from Confreres con "
            + " where (:lastName is null or :lastName= '' or  UPPER(con.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:cin is null or :cin= '' or  UPPER(con.cin) like '%'||UPPER(:cin)||'%')  and "
            + " (:cnss is null or :cnss= '' or  UPPER(con.cnss) like '%'||UPPER(:cnss)||'%')  and "
            + " (:email is null or :email= '' or  UPPER(con.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(con.phone) like '%'|| UPPER(:phone)||'%')  and "
            + " (:address is null or :address= '' or  UPPER(con.address) like '%'|| UPPER(:address)||'%') "
    )
    long count(@Param("lastName") final String lastName,
               @Param("cin") final String cin,
               @Param("cnss") final String cnss,
               @Param("email") final String email,
               @Param("phone") final String phone,
               @Param("address") final String address);

}
