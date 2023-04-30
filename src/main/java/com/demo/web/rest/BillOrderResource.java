//package com.demo.web.rest;
//
//import com.demo.service.BillOrderService;
//import com.demo.web.dto.BillOrderDto;
//import com.demo.web.dto.request.BillOrderReq;
//import com.demo.web.dto.response.utils.ResponseUtils;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequestMapping("api/admin/bill-order")
//@RequiredArgsConstructor
//public class BillOrderResource {
//    private final BillOrderService billOrderService;
//    @PostMapping("/billorder")
//    public ResponseEntity<?> addBillOrder(@RequestBody BillOrderReq billOrderReq){
//        billOrderService.addBillOrder(billOrderReq);
//        return ResponseUtils.created();
//    }
//}
