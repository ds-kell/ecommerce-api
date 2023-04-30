package com.demo.web.dto.request;

import com.demo.model.Discount;
import lombok.Data;


@Data
public class ProductDetailReq {
    private float price;
    private int count;
    private Integer productId;
    private Integer discountId;
//    private Discount discount;

    private Integer colorId;
    private Integer sizeId;
}
