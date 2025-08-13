package com.yashank.order_service.Service;

import com.yashank.order_service.DTO.OrderRequest;
import com.yashank.order_service.DTO.OrderResponse;

public interface OrderService {
    public OrderResponse placeOrder(OrderRequest orderRequest);
}
