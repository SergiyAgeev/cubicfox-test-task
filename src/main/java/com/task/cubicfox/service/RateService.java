package com.task.cubicfox.service;

import com.task.cubicfox.entity.Rate;

public interface RateService {

    void save(Rate rate);

    Double getRateByProductId(Long productId);
}
