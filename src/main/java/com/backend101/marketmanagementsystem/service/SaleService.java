package com.backend101.marketmanagementsystem.service;

import com.backend101.marketmanagementsystem.dto.request.SaleRequestDTO;
import com.backend101.marketmanagementsystem.entity.SaleEntity;
import com.backend101.marketmanagementsystem.entity.WarehouseEntity;
import com.backend101.marketmanagementsystem.mapper.SaleMapper;
import com.backend101.marketmanagementsystem.repository.SaleRepository;
import com.backend101.marketmanagementsystem.repository.WarehouseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SaleService {

    SaleRepository saleRepository;
    WarehouseRepository warehouseRepository;
    SaleMapper saleMapper;

    public void save(SaleRequestDTO dto) {
        SaleEntity saleEntity = saleMapper.toEntity(dto);
        saleEntity.setTotalPrice(dto.getPrice().multiply(dto.getQuantity()));
        saleRepository.save(saleEntity);

        WarehouseEntity warehouse = warehouseRepository.findById(dto.getFkWarehouseId()).get();
        BigDecimal newQuantity = warehouse.getQuantity();
        warehouse.setQuantity(newQuantity.subtract(saleEntity.getQuantity()));
        warehouseRepository.save(warehouse);
    }


}
