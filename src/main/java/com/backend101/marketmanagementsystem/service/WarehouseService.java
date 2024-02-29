package com.backend101.marketmanagementsystem.service;

import com.backend101.marketmanagementsystem.dto.request.WarehouseByFkEmployeeIdRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.WarehouseResponseDTO;

import java.util.List;

public interface WarehouseService {

    List<WarehouseResponseDTO> findAllProduct(); //Filtersiz butun mehsullar gelmelidir
    List<WarehouseResponseDTO> findAllProductByFkEmployeeId(WarehouseByFkEmployeeIdRequestDTO dto); //EmployeeId-e gore
}
