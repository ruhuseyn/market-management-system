package com.backend101.marketmanagementsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WarehouseResponseDTO {

    String productNo;
    String productName;
    BigDecimal quantity;
    BigDecimal vat;
    String productGroup;
    String productCategory;
    BigDecimal initialPrice;
    Long inputDate;
    Long expireDate;
    String responsiblePerson;

}
