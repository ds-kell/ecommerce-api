package com.demo.web.rest;

import com.demo.service.ProductService;
import com.demo.web.dto.ProductDetailDto;
import com.demo.web.dto.ProductDto;
import com.demo.web.dto.request.ProductDetailReq;
import com.demo.web.dto.request.ProductReq;
import com.demo.web.dto.response.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/admin/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductMngResource {
    

    private final ProductService productService;
    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductReq productReq){
        productService.addProduct(productReq);
        return ResponseUtils.created();
    }
    @PostMapping("/add-detail")
    public ResponseEntity<?> addProduct(@RequestBody ProductDetailReq productDetailReq){
        productService.addProductDetail(productDetailReq);
        return ResponseUtils.created();
    }
    @PostMapping("/update/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto, @PathVariable Integer productId){
        productService.updateProduct(productDto);
        return ResponseUtils.ok();
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<?> removeProductCart(@PathVariable Integer productId){
        productService.removeProduct(productId);
        return ResponseUtils.ok("Removed");
    }
}
