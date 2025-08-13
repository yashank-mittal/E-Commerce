package com.yashank.inventory_service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.yashank.inventory_service.Dbo.InventoryDbo;
import com.yashank.inventory_service.Service.InventoryService;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    
    private final InventoryDbo inventoryDbo;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryDbo.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);
    }
}
