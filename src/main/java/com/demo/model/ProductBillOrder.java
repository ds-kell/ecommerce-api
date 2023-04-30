package com.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "productbillorder")
@Data
public class ProductBillOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "productDetail_id")
    private ProductDetail productDetail;
    @ManyToOne
    @JoinColumn(name = "bill_order_id")
    private BillOrder billOrder;
    @Column(name = "quantity")
//    giá nhập
    private int quantity;
    @Column(name = "price")
    private float price;
}