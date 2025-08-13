package com.yashank.product_service.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductRequest {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
