package com.task.cubicfox.service.implementations;

import com.task.cubicfox.service.ProductService;
import com.task.cubicfox.service.RateService;
import com.task.cubicfox.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private RateService rateService;

    @Override
    public void save(Long userId, Long productId, Integer rate) {

    }
}
