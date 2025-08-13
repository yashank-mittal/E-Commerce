package com.yashank.inventory_service.Service;

public interface InventoryService {
    public boolean isInStock(String skuCode, Integer quantity);
}
