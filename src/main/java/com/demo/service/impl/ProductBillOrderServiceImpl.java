package com.demo.service.impl;

import com.demo.model.*;
import com.demo.repository.BillOrderRepository;
import com.demo.repository.ProductBillOrderRepository;
import com.demo.repository.ProductDetailRepository;
import com.demo.repository.ProductRepository;
import com.demo.service.AuthService;
import com.demo.service.ProductBillOrderService;
import com.demo.web.dto.request.ProductBillOrderReq;
import com.demo.web.dto.request.ProductDetailReq;
import com.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductBillOrderServiceImpl implements ProductBillOrderService {

    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductBillOrderRepository productBillOrderRepository;
    private final BillOrderRepository billOrderRepository;
    private final AuthService authService;
    @Override
    public void addProductBillOrder(ProductDetailReq productDetailReq, ProductDetail productDetail){

        BillOrder billOrder = new BillOrder();
        billOrder.setTotalAmount(productDetailReq.getPrice() * productDetailReq.getCount());
        billOrder.setStatus("Hoàn thành");
        billOrder.setPaymentTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        Account account = authService.getCurrentUser();
        billOrder.setAccount(account);

        ProductBillOrder productBillOrder = new ProductBillOrder();
        productBillOrder.setProductDetail(productDetail);
        productBillOrder.setQuantity(productDetailReq.getCount());
        productBillOrder.setPrice(productDetailReq.getPrice());

        List<ProductBillOrder> productBillOrders = new ArrayList<>();
        productBillOrders.add(productBillOrder);
        billOrder.setProductOrders(productBillOrders);
        billOrderRepository.save(billOrder);
    }
}
