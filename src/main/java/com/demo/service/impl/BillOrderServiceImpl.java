package com.demo.service.impl;

import com.demo.model.BillOrder;
import com.demo.model.ProductBillOrder;
import com.demo.repository.BillOrderRepository;
import com.demo.repository.ProductBillOrderRepository;
import com.demo.service.BillOrderService;
import com.demo.service.utils.MappingHelper;
import com.demo.web.dto.BillOrderDto;
import com.demo.web.dto.ProductBillOrderDto;
import com.demo.web.dto.request.BillOrderReq;
import com.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BillOrderServiceImpl implements BillOrderService {
    private  final BillOrderRepository billOrderRepository;
    private final ProductBillOrderRepository productBillOrderRepository;
    private final MappingHelper mappingHelper;
    @Override
    public List<BillOrderDto> getBillOrder(){
        return billOrderRepository.findAll()
                .stream()
                .map(e -> mappingHelper.map(e, BillOrderDto.class))
                .collect(Collectors.toList());

    }
}


/*
        List<BillOrder> billOrders = billOrderRepository.findAll();
        List<BillOrderDto> billOrderDtos = new ArrayList<>();
        for(BillOrder billOrder: billOrders){
            List<ProductBillOrderDto> productBillOrderDtos = productBillOrderRepository.findByBillOrderId(billOrder.getId())
                    .stream()
                    .map(e -> mappingHelper.map(e, ProductBillOrderDto.class))
                    .collect(Collectors.toList());
            BillOrderDto billOrderDto = new BillOrderDto();
            billOrderDto = mappingHelper.map(billOrder, BillOrderDto.class);
            billOrderDto.setProductBillOrdersDto(productBillOrderDtos);
            billOrderDtos.add(billOrderDto);
        }
        return billOrderDtos;
 */