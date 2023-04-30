package com.demo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DiscountDto {
    private Integer id;
    private String name;
    private int value;
    private Instant endDate;
}
