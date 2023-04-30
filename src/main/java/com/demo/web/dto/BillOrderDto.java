package com.demo.web.dto;

import com.demo.model.Account;
import com.demo.web.dto.request.ProductBillOrderReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BillOrderDto {
    private Integer id;
    private String status;
    private Date paymentTime;
    private float totalAmount;
//    private Account account;
    private List<ProductBillOrderDto> productBillOrdersDto;
}
