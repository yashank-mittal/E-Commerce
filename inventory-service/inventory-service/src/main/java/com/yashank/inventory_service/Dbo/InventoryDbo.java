package com.yashank.inventory_service.Dbo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yashank.inventory_service.modal.Inventory;

@Repository
public interface InventoryDbo extends JpaRepository<Inventory,Long> {
    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);
}
