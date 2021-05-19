package com.pharm.service.interfaces.contact;


import com.pharm.model.Contact;

import java.util.List;

public interface ContactService {

    Contact create(Contact contact) ;
    Contact delete(Contact contact);
    Contact update(Contact contact);
    Contact findById(Long id);

    List<Contact> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, Contact filter);
}
