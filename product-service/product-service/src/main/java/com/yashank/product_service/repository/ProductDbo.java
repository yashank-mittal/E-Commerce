package com.yashank.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yashank.product_service.modals.Product;

@Repository
public interface ProductDbo extends MongoRepository<Product,String> {
    
}
