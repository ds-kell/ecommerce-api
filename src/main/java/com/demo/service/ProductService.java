package com.demo.service;

import com.demo.web.dto.ProductDetailDto;
import com.demo.web.dto.ProductDto;
import com.demo.web.dto.request.ProductCriteria;
import com.demo.web.dto.request.ProductDetailReq;
import com.demo.web.dto.request.ProductReq;

import java.util.List;

public interface ProductService {

    ProductDetailDto getProductById(Integer productId);

    void addProduct(ProductReq productReq);

    void updateProduct(ProductDto productDto);

    void addProductDetail(ProductDetailReq productDetailReq);

    void updateProductDetail(ProductDetailDto productDetailDto);

    void removeProduct(Integer productId);

    List<ProductDto> getProducts();
    List<ProductDetailDto> getProductDetailsByProductId(Integer productId);

}
