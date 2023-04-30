package com.demo.service;

import com.demo.web.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrder();
}
