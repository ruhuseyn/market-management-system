package com.backend101.marketmanagementsystem.repository;

import com.backend101.marketmanagementsystem.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity,String> {

    List<WarehouseEntity> findAllByFkEmployeeId(String fkEmployeeId);
}
