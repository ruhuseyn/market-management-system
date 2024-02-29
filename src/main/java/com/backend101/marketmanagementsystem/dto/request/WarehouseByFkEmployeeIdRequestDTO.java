package com.backend101.marketmanagementsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WarehouseByFkEmployeeIdRequestDTO {

    String fkEmployeeId;
}
