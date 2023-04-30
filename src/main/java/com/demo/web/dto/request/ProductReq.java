package com.demo.web.dto.request;

import com.demo.model.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class ProductReq {
    private String name;
    private String description;
    private Date createdAt;
    private Integer categoryId;
    private Integer materialId;
    private Integer supplierId;

}
