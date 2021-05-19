package com.pharm.service.impl.range;

import com.pharm.model.Range;
import com.pharm.repository.range.RangeRepository;
import com.pharm.service.interfaces.range.RangeService;
import com.pharm.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RangeServiceImpl implements RangeService {

    @Autowired
    private RangeRepository rangeRepository;

    @Override
    public List<Range> findAll() {
        return rangeRepository.findAll();
    }

    @Override
    public Range findById(Long id) {
        Optional<Range> optionalRange = rangeRepository.findById(id);
        if(optionalRange.isPresent()){
            return optionalRange.get();
        }
        return null;
    }

    @Override
    public Range create(Range range) {
        range.setStatus(CommonConstant.ACTIVE);
        return rangeRepository.save(range);
    }

    @Override
    public Range update(Range range) {
        if (range.getId()!=null){
            Range persisted = findById(range.getId());
            if(persisted==null){
                return null;
            }
            range.setStatus(CommonConstant.ACTIVE);
            return rangeRepository.save(range);
        }
        return range;
    }

    @Override
    public Range delete(Range range) {
        if (range.getId()!=null && range!=null){
            Range deleted = findById(range.getId());
            if (deleted!=null){
                deleted.setStatus(CommonConstant.DELETE);
                return rangeRepository.save(deleted);
            }

        }
        return null;
    }
}
