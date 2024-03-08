package com.backend101.marketmanagementsystem.service;

import com.backend101.marketmanagementsystem.dto.dto.SaleReadDTO;
import com.backend101.marketmanagementsystem.dto.dto.WarehouseReadDTO;
import com.backend101.marketmanagementsystem.dto.request.SaleReadRequestDTO;
import com.backend101.marketmanagementsystem.dto.request.SaleRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.SaleReadResponseDTO;
import com.backend101.marketmanagementsystem.entity.SaleEntity;
import com.backend101.marketmanagementsystem.entity.WarehouseEntity;
import com.backend101.marketmanagementsystem.exception.notfound.WarehouseNotFoundException;
import com.backend101.marketmanagementsystem.mapper.SaleMapper;
import com.backend101.marketmanagementsystem.mapper.WarehouseMapper;
import com.backend101.marketmanagementsystem.repository.SaleRepository;
import com.backend101.marketmanagementsystem.repository.WarehouseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SaleService {

    SaleRepository saleRepository;
    WarehouseRepository warehouseRepository;
    SaleMapper saleMapper;
    WarehouseMapper warehouseMapper;

    public void save(SaleRequestDTO dto) {
        SaleEntity saleEntity = saleMapper.toEntity(dto);
        saleEntity.setTotalPrice(dto.getPrice().multiply(dto.getQuantity()));
        saleRepository.save(saleEntity);

        WarehouseEntity warehouse = warehouseRepository.findById(dto.getFkWarehouseId()).get();
        BigDecimal newQuantity = warehouse.getQuantity();
        warehouse.setQuantity(newQuantity.subtract(saleEntity.getQuantity()));
        warehouseRepository.save(warehouse);
    }


    public List<SaleReadResponseDTO> read(SaleReadRequestDTO dto){
        List<SaleEntity> saleEntityList = saleRepository.findAllByPrice(dto.getPrice());

        List<SaleReadResponseDTO> responseList = new ArrayList<>();
        for(SaleEntity saleEntity: saleEntityList){
            WarehouseEntity entity = warehouseRepository.findById(saleEntity.getFkWarehouseId())
                    .orElseThrow(()->new WarehouseNotFoundException("Anbar tapilmadi"));
            SaleReadDTO saleReadDTO = saleMapper.toSaleReadDTO(saleEntity);
            WarehouseReadDTO warehouseReadDTO = warehouseMapper.toWarehouseReadDTO(entity);

            SaleReadResponseDTO responseDTO = SaleReadResponseDTO
                    .builder()
                    .saleReadDTO(saleReadDTO)
                    .warehouseReadDTO(warehouseReadDTO)
                    .build();

            responseList.add(responseDTO);
        }
        return responseList;
    }


}
