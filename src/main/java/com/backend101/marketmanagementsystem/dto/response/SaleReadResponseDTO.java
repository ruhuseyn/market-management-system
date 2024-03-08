package com.backend101.marketmanagementsystem.dto.response;

import com.backend101.marketmanagementsystem.dto.dto.SaleReadDTO;
import com.backend101.marketmanagementsystem.dto.dto.WarehouseReadDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleReadResponseDTO {

    SaleReadDTO saleReadDTO;
    WarehouseReadDTO warehouseReadDTO;
}
