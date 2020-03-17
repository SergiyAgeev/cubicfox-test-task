package com.task.cubicfox.service.implementations;

import com.task.cubicfox.entity.Rate;
import com.task.cubicfox.exceptions.DataProcessingException;
import com.task.cubicfox.repository.RateRepository;
import com.task.cubicfox.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;

    public RateServiceImpl(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public void save(Rate rate) {
        if (rate.getRate() > 10 && rate.getRate() < 0) {
            throw new DataProcessingException("Wrong rate value");
        }
        rateRepository.save(rate);
        log.info("rate was saved for " + rate.getProduct());
    }

    @Override
    public Double getRateByProductId(Long productId) {
        Double rate = rateRepository.getRateByProductId(productId);
        log.info("average rate was successfully get product with id = " + productId);
        return rate;
    }
}
