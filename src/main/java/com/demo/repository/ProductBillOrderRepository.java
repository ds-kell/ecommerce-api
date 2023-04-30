package com.demo.repository;

import com.demo.model.ProductBillOrder;
import com.demo.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductBillOrderRepository extends JpaRepository<ProductBillOrder, Integer> {
    List<ProductBillOrder> findByBillOrderId (Integer productId);

    Optional<ProductBillOrder> findFirstByBillOrder_Id(Integer id);
}
