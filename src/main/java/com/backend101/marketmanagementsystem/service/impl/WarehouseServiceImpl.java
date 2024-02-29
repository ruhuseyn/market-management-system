package com.backend101.marketmanagementsystem.service.impl;

import com.backend101.marketmanagementsystem.dto.request.WarehouseByFkEmployeeIdRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.WarehouseResponseDTO;
import com.backend101.marketmanagementsystem.mapper.WarehouseMapper;
import com.backend101.marketmanagementsystem.repository.WarehouseRepository;
import com.backend101.marketmanagementsystem.service.WarehouseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseServiceImpl implements WarehouseService {

    WarehouseRepository warehouseRepository;
    WarehouseMapper warehouseMapper;

    @Override
    public List<WarehouseResponseDTO> findAllProduct() {
        return warehouseRepository.findAll().stream()
                .map(warehouseMapper::toWarehouseResponseDto).toList();
    }

    @Override
    public List<WarehouseResponseDTO> findAllProductByFkEmployeeId(WarehouseByFkEmployeeIdRequestDTO dto) {
        return warehouseRepository.findAllByFkEmployeeId(dto.getFkEmployeeId()).stream()
                .map(warehouseMapper::toWarehouseResponseDto).toList();
    }
}
