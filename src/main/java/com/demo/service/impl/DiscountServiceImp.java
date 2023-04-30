package com.demo.service.impl;

import com.demo.service.DiscountService;
import com.demo.web.dto.DiscountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiscountServiceImp implements DiscountService {
    @Override
    public void addDiscount(DiscountDto discountDto){

    }

    @Override
    public void removeDiscount(Integer discountId){

    }

    @Override
    public void updateDiscount(Integer discountId){

    }
    @Override
    public List<DiscountDto> getDiscount() {
        return null;
    }
}
