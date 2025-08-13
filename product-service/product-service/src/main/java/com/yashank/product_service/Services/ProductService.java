package com.yashank.product_service.Services;

import java.util.List;

import com.yashank.product_service.DTO.ProductRequest;
import com.yashank.product_service.DTO.ProductResponse;

public interface ProductService {
    public ProductResponse createProduct(ProductRequest productRequest);
    public List<ProductResponse> getAllProducts();
}
