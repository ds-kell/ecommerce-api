package com.demo.service;

import com.demo.model.ProductDetail;
import com.demo.web.dto.request.ProductBillOrderReq;
import com.demo.web.dto.request.ProductDetailReq;

public interface ProductBillOrderService {
    void addProductBillOrder(ProductDetailReq productDetailReq, ProductDetail productDetail);
}
