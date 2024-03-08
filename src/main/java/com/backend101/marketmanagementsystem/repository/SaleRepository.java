package com.backend101.marketmanagementsystem.repository;

import com.backend101.marketmanagementsystem.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity,String> {


    List<SaleEntity> findAllByPrice(BigDecimal price);
}
