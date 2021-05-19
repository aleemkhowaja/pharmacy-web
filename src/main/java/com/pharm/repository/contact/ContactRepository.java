package com.pharm.repository.contact;

import com.pharm.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
    @Query("select distinct con from Contact con "
            + " where  (:firstName is null or :firstName= '' or  UPPER(con.firstName) like '%'||UPPER(:firstName)||'%')  and "
            + "(:lastName is null or :lastName= '' or  UPPER(con.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:title is null or :title= '' or  UPPER(con.title) like '%'||UPPER(:title)||'%')  and "
            + " (:email is null or :email= '' or  UPPER(con.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(con.phone) like '%'|| UPPER(:phone)||'%') "
    )
    Page<Contact> filter(@Param("firstName") final String firstName,
                         @Param("lastName") final String lastName,
                         @Param("title") final String title,
                         @Param("email") final String email,
                         @Param("phone") final String phone,
                         Pageable pageable);


    @Query("select count(con) from Contact con "
            + " where  (:firstName is null or :firstName= '' or  UPPER(con.firstName) like '%'||UPPER(:firstName)||'%')  and "
            + "(:lastName is null or :lastName= '' or  UPPER(con.lastName) like '%'|| UPPER(:lastName)||'%') and "
            + " (:title is null or :title= '' or  UPPER(con.title) like '%'||UPPER(:title)||'%')  and "
            + " (:email is null or :email= '' or  UPPER(con.email) like '%'|| UPPER(:email)||'%')  and "
            + " (:phone is null or :phone= '' or  UPPER(con.phone) like '%'|| UPPER(:phone)||'%') "
    )
    long count(@Param("firstName") final String firstName,
               @Param("lastName") final String lastName,
               @Param("title") final String title,
               @Param("email") final String email,
               @Param("phone") final String phone);

}
