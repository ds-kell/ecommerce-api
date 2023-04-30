package com.demo.service;

import com.demo.model.BillOrder;
import com.demo.web.dto.BillOrderDto;
import com.demo.web.dto.request.BillOrderReq;

import java.util.List;

public interface BillOrderService {

//    void addBillOrder(BillOrderReq billOrderReq);
    List<BillOrderDto> getBillOrder();
}
