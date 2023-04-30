package com.demo.web.rest;

import com.demo.service.*;
import com.demo.web.dto.ProductDto;
import com.demo.web.dto.SupplierDto;
import com.demo.web.dto.request.ProductCriteria;
import com.demo.web.dto.response.utils.ResponseUtils;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin
public class AdminResource {
    private final ProductService productService;
    private final ProfileService profileService;
    private final StoreService storeService;

    private final SupplierService supplierService;

    private final OrderService orderService;

    private final ColorService colorService;
    private final MaterialService materialService;
    private final BillOrderService billOrderService;
    @GetMapping("/admin-home")
    public String homePage(){
        return "admin/admin-home";
    }
    @GetMapping("/admin-profile")
    public ResponseEntity<?> getAdminProfile(){
        return ResponseUtils.ok(profileService.getCustomerProfile());
    }

    @GetMapping("/store-profile")
    public ResponseEntity<?> getStoreProfile(){ return ResponseUtils.ok(storeService.getStoreProfile(1));}

    @GetMapping("/get-product-detail")
    public ResponseEntity<?> getProducts(@RequestParam Integer productId) {
        return ResponseUtils.ok(productService.getProductDetailsByProductId(productId));
    }
    @PostMapping("/products")
    public ResponseEntity<?> getProducts() {
        return ResponseUtils.ok(productService.getProducts());
    }

    @GetMapping("/suppliers")
    public ResponseEntity<?> getSupplier(){ return ResponseUtils.ok(supplierService.getSupplier());}

    @GetMapping("/color")
    public ResponseEntity<?> getColor(){ return  ResponseUtils.ok(colorService.getColor());}
    @GetMapping("/staff")
    public ResponseEntity<?> getStaff(){ return ResponseUtils.ok(profileService.getStaff());}

    @GetMapping("/order")
    public ResponseEntity<?> getOrder(){ return ResponseUtils.ok(orderService.getOrder());}

    @GetMapping("/material")
    public ResponseEntity<?> getMaterial(){ return ResponseUtils.ok(materialService.getMaterial());}

    @GetMapping("/get-bill-order")
    public ResponseEntity<?> getBillOrder() { return ResponseUtils.ok(billOrderService.getBillOrder());}
}
