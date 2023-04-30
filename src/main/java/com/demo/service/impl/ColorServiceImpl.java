package com.demo.service.impl;

import com.demo.repository.ColorRepository;
import com.demo.service.ColorService;
import com.demo.service.utils.MappingHelper;
import com.demo.web.dto.ColorDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final MappingHelper mappingHelper;
    private final ColorRepository colorRepository;
    @Override
    public List<ColorDto> getColor() { {
            return colorRepository.findAll()
                    .stream()
                    .map(product -> mappingHelper.map(product, ColorDto.class))
                    .collect(Collectors.toList());
        }
    }
}
