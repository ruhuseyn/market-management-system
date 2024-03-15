package com.backend101.marketmanagementsystem.repository;

import com.backend101.marketmanagementsystem.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    OrderEntity findByFkProductId(String fkProductId);
}
