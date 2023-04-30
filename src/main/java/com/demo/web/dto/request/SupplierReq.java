package com.demo.web.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SupplierReq {
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
    private String note;
}
