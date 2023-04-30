package com.demo.web.rest;

import com.demo.service.SupplierService;
import com.demo.web.dto.SupplierDto;
import com.demo.web.dto.request.SupplierReq;
import com.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/admin/supplier")
@RequiredArgsConstructor
@CrossOrigin
public class SupplierMngResource {
    private final SupplierService supplierService;
    @PostMapping("/add")
    public ResponseEntity<?> addSupplier(@RequestBody SupplierReq supplierReq){
        supplierService.addSupplier(supplierReq);
        return ResponseUtils.created();
    }

}
