package com.pharm.service.impl.delivery;

import com.pharm.model.Delivery;
import com.pharm.repository.delivery.DeliveryRepository;
import com.pharm.service.interfaces.delivery.DeliveryService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery findById(Long id) {
        Optional<Delivery> optional = deliveryRepository.findById(id);
        if(optional.isPresent())
        {
            return optional.get();
        }
        return null;
    }

    @Override
    public Delivery create(Delivery delivery) {
        delivery.setStatus(CommonConstant.ACTIVE);
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery update(Delivery delivery) {
        if (delivery.getId() != null)
        {
            Delivery persisted = findById(delivery.getId());
            if (persisted==null)
            {
                return null;
            }
            delivery.setStatus(CommonConstant.ACTIVE);
            return deliveryRepository.save(delivery);
        }
        return null;
    }

    @Override
    public Delivery delete(Delivery delivery) {
        if (delivery.getId()!=null && delivery!=null)
        {
            Delivery delete = findById(delivery.getId());
            if (delete!=null)
            {
                delete.setStatus(CommonConstant.DELETE);
                return deliveryRepository.save(delete);
            }
        }
        return null;
    }

    @Override
    public List<Delivery> findAllByProductId(Long id) {
        return deliveryRepository.findAllByProductId(id);
    }

}
