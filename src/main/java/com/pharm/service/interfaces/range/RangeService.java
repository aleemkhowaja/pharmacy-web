package com.pharm.service.interfaces.range;

import com.pharm.model.Range;

import java.util.List;

public interface RangeService {
    List<Range> findAll();
    Range findById(Long id);
    Range create(Range range);
    Range update(Range range);
    Range delete(Range range);
}
