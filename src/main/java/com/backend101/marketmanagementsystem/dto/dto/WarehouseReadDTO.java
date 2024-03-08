package com.backend101.marketmanagementsystem.dto.dto;

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
public class WarehouseReadDTO {

    String responsiblePerson;
    String productNo;
    String productName;
    String isActive;
    BigDecimal quantity;
    String productGroup;
    String productCategory;
    BigDecimal vat;
    BigDecimal initialPrice;
    Long expireDate;
}
