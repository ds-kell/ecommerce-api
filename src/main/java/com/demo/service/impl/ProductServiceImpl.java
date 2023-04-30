package com.demo.service.impl;

import com.demo.model.BillOrder;
import com.demo.model.Product;
import com.demo.model.ProductBillOrder;
import com.demo.model.ProductDetail;
import com.demo.repository.*;
import com.demo.service.ProductBillOrderService;
import com.demo.service.ProductService;
import com.demo.service.utils.MappingHelper;
import com.demo.web.dto.ProductDetailDto;
import com.demo.web.dto.ProductDto;
import com.demo.web.dto.request.*;
import com.demo.web.exception.EntityNotFoundException;
import com.demo.web.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;
    private final MappingHelper mappingHelper;
    private final SizeRepository sizeRepository;
    private final CartRepository cartRepository;
    private final ColorRepository colorRepository;
    private final AuthServiceImpl authService;
    private final CategoryRepository categoryRepository;
    private final MaterialRepository materialRepository;
    private final SupplierRepository supplierRepository;
    private final DiscountRepository discountRepository;
    private final ProductBillOrderService productBillOrderService;
    @Override
    public List<ProductDetailDto> getProductDetailsByProductId(Integer productId) {
        return productDetailRepository.findByProductId(productId)
                .stream().map(e ->
                        mappingHelper.map(e, ProductDetailDto.class)
                ).collect(Collectors.toList());
    }

    @Override
    public ProductDetailDto getProductById(Integer productId) {
        var productDetail = productDetailRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productId.toString()));
        return mappingHelper.map(productDetail, ProductDetailDto.class);
    }

    @Override
    public void addProduct(ProductReq productReq) {
        Product product = new Product();
        product.setName(productReq.getName());
        product.setCategory(categoryRepository.findById(productReq.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException(Product.class.getName(), productReq.getCategoryId().toString())));
        product.setMaterial(materialRepository.findById(productReq.getMaterialId())
                .orElseThrow(() -> new EntityNotFoundException(Product.class.getName(), productReq.getMaterialId().toString())));
        product.setSupplier(supplierRepository.findById(productReq.getSupplierId())
                .orElseThrow(() -> new EntityNotFoundException(Product.class.getName(), productReq.getSupplierId().toString())));
        product.setCreatedAt(productReq.getCreatedAt());
        product.setDescription(productReq.getDescription());
//        product.setImages(productReq.getImages);
        productRepository.save(product);
    }

    @Override
    public void addProductDetail(ProductDetailReq productDetailReq) {
        Product product = productRepository.findById(productDetailReq.getProductId())
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productDetailReq.getProductId().toString()));
        ProductDetail productDetail = new ProductDetail();
        productDetail.setPrice(productDetailReq.getPrice());
        productDetail.setProduct(productRepository.findById(productDetailReq.getProductId())
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productDetailReq.getProductId().toString())));
        productDetail.setDiscount(discountRepository.findById(productDetailReq.getDiscountId())
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productDetailReq.getDiscountId().toString())));
        productDetail.setColor(colorRepository.findById(productDetailReq.getColorId())
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productDetailReq.getColorId().toString())));
        productDetail.setCountInStock(productDetailReq.getCount());
        productDetail.setSize(sizeRepository.findById(productDetailReq.getSizeId())
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productDetailReq.getSizeId().toString())));
        productDetailRepository.save(productDetail);
        productBillOrderService.addProductBillOrder(productDetailReq, productDetail);

    }

    @Override
    public void updateProductDetail(ProductDetailDto productDetailDto) {
//        price, count in stock, discount
        ProductDetail productDetail = productDetailRepository.findById(productDetailDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(ProductDetail.class.getName(), productDetailDto.getId().toString()));
        productDetail.setCountInStock(productDetail.getCountInStock() + productDetailDto.getCountInStock());
        productDetail.setPrice(productDetailDto.getPrice());
        productDetail.setDiscount(productDetailDto.getDiscount());
        productDetailRepository.save(productDetail);
    }

    @Override
    public void updateProduct(ProductDto productDto) {

    }

    @Override
    public void removeProduct(Integer productDetailId) {
//        check cart
        if (cartRepository.findById(productDetailId).isPresent()) {
            throw new ServiceException("Product is in the cart", "err.api.product-is-in-the-cart");
        }
//        check bill order p

//        check pill payment

//        check assessment

//        check image
    }

    //    @Override
//    public List<ProductDto> getProducts() {
//        return productRepository.findAll()
//                .stream().map(e -> {
//                    ProductDto res = mappingHelper.map(e, ProductDto.class);
//                    var productDetail = productDetailRepository.findFirstByProduct_Id(e.getId())
//                            .orElseThrow(() -> new EntityNotFoundException(Product.class.getName(), e.getId().toString()));
//                    res.setDiscount(productDetail.getDiscount());
//                    res.setPrice(productDetail.getPrice());
//                    return res;
//                })
//                .filter(e -> e.getDiscount() != null)
//                .collect(Collectors.toList());
//    }
    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(e -> mappingHelper.map(e, ProductDto.class))
                .collect(Collectors.toList());
    }
}