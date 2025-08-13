package com.yashank.inventory_service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.yashank.inventory_service.Service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
    
    private final InventoryService inventoryService;

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity)
    {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
