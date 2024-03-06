package com.backend101.marketmanagementsystem.mapper;

import com.backend101.marketmanagementsystem.dto.request.SaleRequestDTO;
import com.backend101.marketmanagementsystem.entity.SaleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleEntity toEntity(SaleRequestDTO dto);
}
