package com.demo.web.dto;

import com.demo.model.BillOrder;
import com.demo.model.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductBillOrderDto {
    private Integer id;
    private ProductDetail productDetail;
    private BillOrder billOrder;
    private int quantity;
    private float price;
}
