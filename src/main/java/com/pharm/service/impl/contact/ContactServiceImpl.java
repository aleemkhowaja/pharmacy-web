package com.pharm.service.impl.contact;

import com.pharm.model.Contact;
import com.pharm.repository.contact.ContactRepository;
import com.pharm.service.interfaces.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public Contact create(Contact contact) {
        contact.setStatus("A");
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public Contact delete(Contact contact) {
        if(contact!=null && contact.getId()!=null){
            contact.setStatus(DELETE);
        }

        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public Contact update(Contact contact) {
        if (contact.getId() != null) {
            Contact persisted = findById(contact.getId());
            if (persisted == null) {
                return null;
            }
            Contact updated = contactRepository.save(contact);
            return updated;
        }
        return null;
    }

    @Override
    @Transactional
    public Contact findById(Long id) {
        Optional<Contact> optional = contactRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
