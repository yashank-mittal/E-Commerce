package com.yashank.product_service.ServiceImplementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yashank.product_service.DTO.ProductRequest;
import com.yashank.product_service.DTO.ProductResponse;
import com.yashank.product_service.Services.ProductService;
import com.yashank.product_service.modals.Product;
import com.yashank.product_service.repository.ProductDbo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductDbo productDbo;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
       Product product = Product.builder()
                                .name(productRequest.getName())
                                .description(productRequest.getDescription())
                                .price(productRequest.getPrice())
                                .build();
        productDbo.save(product);
        log.info("Product created Successfully");
        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productDbo.findAll()
            .stream()
            .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice()))
            .toList();
    }
    
}
