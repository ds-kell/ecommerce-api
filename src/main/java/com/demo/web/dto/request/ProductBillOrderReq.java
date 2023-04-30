package com.demo.web.dto.request;

import com.demo.model.BillOrder;
import com.demo.model.ProductDetail;
import lombok.Data;

@Data
public class ProductBillOrderReq {
    private Integer id;
    private BillOrder billOrder;
    private ProductDetail productDetail;
    private int quantity;
    private float price;
}
