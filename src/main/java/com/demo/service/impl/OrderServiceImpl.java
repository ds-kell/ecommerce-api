package com.demo.service.impl;

import com.demo.repository.OrderRepository;
import com.demo.service.OrderService;
import com.demo.web.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public List<OrderDto> getOrder(){
        return null;
    }
}
