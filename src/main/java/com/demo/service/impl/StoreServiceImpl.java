package com.demo.service.impl;

import com.demo.repository.StoreRepository;
import com.demo.service.StoreService;
import com.demo.service.utils.MappingHelper;
import com.demo.web.dto.StoreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    private final MappingHelper mappingHelper;
    private final StoreRepository storeRepository;

    @Override
    public StoreDto getStoreProfile(Integer storeId){
        return storeRepository.getStoreById(storeId)
                .map(store -> {
                    var storeDto = mappingHelper.map(store, StoreDto.class);
                    ResponseEntity.ok(store);
                    return storeDto;
                })
                .orElseThrow(() -> new RuntimeException("Not found profile with id: " + storeId));
    }
    @Override
    public void updateStore(Integer storeId){

    }
}
