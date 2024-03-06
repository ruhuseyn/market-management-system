package com.backend101.marketmanagementsystem.dto.request;

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
public class SaleRequestDTO {

    String productName;
    Long deliveryDate;
    Long paymentDate;
    BigDecimal quantity;
    String unit;
    BigDecimal vat;
    BigDecimal price;
    String fkProductId;
    String fkWarehouseId;
    String productCategory;

}

