package com.pharm.controller.range;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pharm.model.Range;
import com.pharm.service.interfaces.range.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RangeController implements GraphQLQueryResolver, GraphQLMutationResolver {
    @Autowired
    private RangeService rangeService;

    public List<Range> getAllRanges(){
        return rangeService.findAll();
    }
    public Range getRangeById(Long id){
        return rangeService.findById(id);
    }
    public Range createRange(Range range){
        return rangeService.create(range);
    }
    public Range updateRange(Range range){ return rangeService.update(range); }
    public Range deleteRange(Long id){
        Range range= new Range();
        range.setId(id);
        return rangeService.delete(range);
    }
}
