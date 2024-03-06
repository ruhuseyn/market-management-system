package com.backend101.marketmanagementsystem.service;

import com.backend101.marketmanagementsystem.dto.request.WarehouseByFkEmployeeIdRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.WarehouseResponseDTO;
import com.backend101.marketmanagementsystem.mapper.WarehouseMapper;
import com.backend101.marketmanagementsystem.repository.WarehouseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseService {

    WarehouseRepository warehouseRepository;
    WarehouseMapper warehouseMapper;

    public List<WarehouseResponseDTO> findAllProduct() {
        return warehouseRepository.findAll().stream()
                .map(warehouseMapper::toWarehouseResponseDto).toList();
    }


    public List<WarehouseResponseDTO> findAllProductByFkEmployeeId(WarehouseByFkEmployeeIdRequestDTO dto) {
        return warehouseRepository.findAllByFkEmployeeId(dto.getFkEmployeeId()).stream()
                .map(warehouseMapper::toWarehouseResponseDto).toList();
    }
}
