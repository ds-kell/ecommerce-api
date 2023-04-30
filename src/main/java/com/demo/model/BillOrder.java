package com.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "billorder")
@Data
public class BillOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status")
    private String status;
    @Column(name = "payment_time")
    private Date paymentTime;
    @Column(name = "total_amount")
    private float totalAmount;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bill_order_id")
    private List<ProductBillOrder> productOrders = new ArrayList<>();
}
