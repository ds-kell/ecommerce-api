package com.demo.service.impl;

import com.demo.model.Supplier;
import com.demo.repository.SupplierRepository;
import com.demo.service.SupplierService;
import com.demo.service.utils.MappingHelper;
import com.demo.web.dto.ProductDetailDto;
import com.demo.web.dto.StoreDto;
import com.demo.web.dto.SupplierDto;
import com.demo.web.dto.request.SupplierReq;
import com.demo.web.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final MappingHelper mappingHelper;

    @Override
    public void addSupplier(SupplierReq supplierReq) {
        if(supplierRepository.findByName(supplierReq.getName()) && supplierRepository.findByPhoneNumber(supplierReq.getPhoneNumber()) && supplierRepository.findByAddress(supplierReq.getAddress())){
            throw new ServiceException("Supplier is existed in system", "err.api.supplier-is-existed");
        }
        System.out.println(supplierReq.getName());
        Supplier supplier = mappingHelper.map(supplierReq, Supplier.class);
        System.out.println(supplier);
        supplierRepository.save(supplier);
    }

    @Override
    public List<SupplierDto> getSupplier() {
        return supplierRepository.findAll()
                .stream()
                .map(supplier -> mappingHelper.map(supplier, SupplierDto.class))
                .collect(Collectors.toList());
    }
}
