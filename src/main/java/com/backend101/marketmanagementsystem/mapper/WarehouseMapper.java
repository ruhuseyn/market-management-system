package com.backend101.marketmanagementsystem.mapper;

import com.backend101.marketmanagementsystem.dto.dto.WarehouseReadDTO;
import com.backend101.marketmanagementsystem.dto.response.WarehouseResponseDTO;
import com.backend101.marketmanagementsystem.entity.WarehouseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    WarehouseResponseDTO toWarehouseResponseDto(WarehouseEntity entity);

    WarehouseReadDTO toWarehouseReadDTO(WarehouseEntity entity);
}
