package com.demo.service;

import com.demo.web.dto.SupplierDto;
import com.demo.web.dto.request.SupplierReq;

import java.util.List;

public interface SupplierService {
    void addSupplier(SupplierReq supplierReq);

    List<SupplierDto> getSupplier();
};