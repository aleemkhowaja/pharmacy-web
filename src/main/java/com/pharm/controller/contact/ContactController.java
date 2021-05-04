package com.pharm.controller.contact;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Contact;
import com.pharm.service.interfaces.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactController implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ContactService contactService;

    public List<Contact> getAllContacts(){
        return contactService.findAll();
    }
    public Contact getContactById(long id){
        return contactService.findById(id);
    }
    public Contact createContact(Contact contact){
        return contactService.create(contact);
    }
    public Contact updateContact(long id,Contact contact){
        contact.setId(id);
        return contactService.update(contact);
    }
    public Contact deleteContact(long id){
        Contact contact = new Contact();
        contact.setId(id);
        return contactService.delete(contact);
    }
}
