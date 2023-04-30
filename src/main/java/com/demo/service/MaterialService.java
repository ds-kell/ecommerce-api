package com.demo.service;

import com.demo.web.dto.MaterialDto;

import java.util.List;

public interface MaterialService {

    void addMaterial(MaterialDto materialDto);

    void removeMaterial(Integer materialId);

    void updateMaterial(Integer materialId);

    List<MaterialDto> getMaterial();
}
