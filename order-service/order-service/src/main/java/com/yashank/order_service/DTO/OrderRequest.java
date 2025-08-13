package com.yashank.order_service.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderRequest {
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
