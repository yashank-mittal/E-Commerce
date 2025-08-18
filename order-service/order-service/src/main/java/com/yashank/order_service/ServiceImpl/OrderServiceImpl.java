package com.yashank.order_service.ServiceImpl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import com.yashank.order_service.exception.OutOfStockException;

import com.yashank.order_service.DTO.OrderRequest;
import com.yashank.order_service.DTO.OrderResponse;
import com.yashank.order_service.Dbo.OrderDbo;
import com.yashank.order_service.Service.OrderService;
import com.yashank.order_service.client.InventoryClient;
import com.yashank.order_service.modal.Order;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDbo orderDbo;
    private final InventoryClient inventoryClient;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());
        if (!isProductInStock) {
            throw new OutOfStockException(orderRequest.getSkuCode());
        }

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.getPrice());
        order.setSkuCode(orderRequest.getSkuCode());
        order.setQuantity(orderRequest.getQuantity());

        Order savedOrder = orderDbo.save(order);

        return OrderResponse.builder()
                .id(savedOrder.getId())
                .orderNumber(savedOrder.getOrderNumber())
                .skuCode(savedOrder.getSkuCode())
                .price(savedOrder.getPrice())
                .quantity(savedOrder.getQuantity())
                .build();

    }
    
}
