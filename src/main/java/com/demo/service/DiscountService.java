package com.demo.service;

import com.demo.web.dto.DiscountDto;

import java.util.List;

public interface DiscountService {
    void addDiscount(DiscountDto discountDto);
    void removeDiscount(Integer discountId);
    void updateDiscount(Integer discountId);
    List<DiscountDto> getDiscount();
}
