package com.demo.service;

import com.demo.web.dto.StoreDto;

public interface StoreService {
    StoreDto getStoreProfile(Integer storeId);

    void updateStore(Integer storeId);
}
