package com.yashank.order_service.Dbo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yashank.order_service.modal.Order;

@Repository
public interface OrderDbo extends JpaRepository<Order,Long> {
    
}
