package com.pharm.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.List;

import static com.pharm.util.CommonConstant.SORT_ASC;

public class PageUtil {
    private static final Logger LOG = LoggerFactory.getLogger(PageUtil.class);

    public static Pageable returnPageable(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy)
    {
        Pageable pageable = null;
        if(sortOrder.equalsIgnoreCase(SORT_ASC))
        {
            return PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        }
        return PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
    }

    /**
     *
     * @param pageNumber
     * @param pageSize
     * @param sortOrder
     * @param sortBy
     * @return
     */
    public static String validatePaginationParams(final int pageNumber, final int pageSize, final String sortOrder, final String sortBy) {
        List<String> validationErrors = new ArrayList<>();
        if (pageNumber<0) {
            LOG.error("Minimum PageNumber =0. PageNumber :{} must be greater than 0", pageNumber);
            validationErrors.add("PageNumber must be greater than or equal to 0!");
        }

        if (pageSize<1) {
            LOG.error("PageSize :{} must be greater than 0", pageSize);
            validationErrors.add("PageSize must be greater than 0");
        }

        if (null == sortOrder) {
            LOG.error("SortOrder :{} must be specified", sortOrder);
            validationErrors.add("SortOrder must be specified");
        }

        if (StringUtils.isBlank(sortBy)) {
            LOG.error("SortBy :{} must be specified", sortBy);
            validationErrors.add("SortBy must be specified");
        }

        if (CollectionUtils.isEmpty(validationErrors)) {
            return null;
        }
        return StringUtils.join(validationErrors, "/n");
    }
}
