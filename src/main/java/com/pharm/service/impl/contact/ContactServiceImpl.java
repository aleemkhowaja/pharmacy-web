package com.pharm.service.impl.contact;

import com.pharm.model.Contact;
import com.pharm.repository.contact.ContactRepository;
import com.pharm.service.interfaces.contact.ContactService;
import com.pharm.util.CommonConstant;
import com.pharm.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.pharm.util.CommonConstant.DELETE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional
    public List<Contact> findAll(int pageNumber, int pageSize, String sortOrder, String sortBy, Contact filter) {
        String validationErrors = PageUtil.validatePaginationParams(pageNumber, pageSize, sortOrder, sortBy);
        if((isNotBlank(validationErrors))) {
            throw new IllegalArgumentException(validationErrors);
        }

        Page<Contact> contacts = contactRepository.filter(filter.getFirstName(), filter.getLastName(),filter.getTitle(), filter.getEmail(),
                filter.getPhone(), PageUtil.returnPageable(pageNumber, pageSize, sortOrder, sortBy));
        if(contacts.hasContent())
        {
            final Long size = contactRepository.count(filter.getFirstName(), filter.getLastName(),filter.getTitle(), filter.getEmail(),
                    filter.getPhone());
            System.out.println("size::"+size);
            contacts.getContent().get(0).setCount(size);
        }
        return contacts.getContent();
    }

    @Override
    @Transactional
    public Contact create(Contact contact) {
        contact.setStatus(CommonConstant.ACTIVE);
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public Contact delete(Contact contact) {
        if(contact!=null && contact.getId()!=null){
            Contact deleted = findById(contact.getId());
            if (deleted != null){
                deleted.setStatus(CommonConstant.DELETE);
                return contactRepository.save(deleted);
            }

        }
        return null;
    }
    @Override
    @Transactional
    public Contact update(Contact contact) {
        if (contact.getId() != null) {
            Contact persisted = findById(contact.getId());
            if (persisted == null) {
                return null;
            }
            contact.setStatus(CommonConstant.ACTIVE);
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
