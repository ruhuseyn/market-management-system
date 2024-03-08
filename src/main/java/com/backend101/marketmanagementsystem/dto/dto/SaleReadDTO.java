package com.backend101.marketmanagementsystem.dto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaleReadDTO {

    String productName;
    Long deliveryDate;
    Long paymentDate;
    BigDecimal quantity;
    String unit;
    BigDecimal price;
    BigDecimal totalPrice;
}
