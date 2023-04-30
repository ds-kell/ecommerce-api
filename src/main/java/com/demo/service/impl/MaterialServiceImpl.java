package com.demo.service.impl;

import com.demo.model.Material;
import com.demo.repository.MaterialRepository;
import com.demo.service.MaterialService;
import com.demo.service.utils.MappingHelper;
import com.demo.web.dto.MaterialDto;
import com.demo.web.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final MaterialRepository materialRepository;
    private final MappingHelper mappingHelper;
    @Override
    public void addMaterial(MaterialDto materialDto){
        if(materialRepository.findByName(materialDto.getName())){
            throw new ServiceException("Material is existed in system", "err.api.material-is-existed");
        }
        Material material = mappingHelper.map(materialDto, Material.class);
        materialRepository.save(material);
    }

    @Override
    public void removeMaterial(Integer materialId){
        if(materialRepository.findById(materialId).isPresent()){
            materialRepository.deleteById(materialId);
        }
        throw new ServiceException("Unknown error", "err.api.materialId-not-existed");
    }

    @Override
    public void updateMaterial(Integer materialId){
    }
    @Override
    public List<MaterialDto> getMaterial() { {
        return materialRepository.findAll()
                .stream()
                .map(material -> mappingHelper.map(material, MaterialDto.class))
                .collect(Collectors.toList());
    }
    }
}
