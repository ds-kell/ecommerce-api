package com.demo.web.dto.request;

import com.demo.model.Account;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class BillOrderReq {
    private String status;
    private Date paymentTime;
    private float totalAmount;
    private Account account;
    private Set<ProductBillOrderReq> productBillOrdersReq;
}
