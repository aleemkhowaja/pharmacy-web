package com.pharm.service.interfaces.contact;


import com.pharm.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAll();
    Contact create(Contact contact) ;
    Contact delete(Contact contact);
    Contact update(Contact contact);
    Contact findById(Long id);
}
