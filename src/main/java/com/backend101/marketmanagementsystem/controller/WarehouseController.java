package com.backend101.marketmanagementsystem.controller;

import com.backend101.marketmanagementsystem.dto.request.WarehouseByFkEmployeeIdRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.WarehouseResponseDTO;
import com.backend101.marketmanagementsystem.service.WarehouseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/erp/management")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class WarehouseController {

    WarehouseService warehouseServiceImpl;

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<WarehouseResponseDTO> findAllProduct(){
        return warehouseServiceImpl.findAllProduct();
    }

    @GetMapping("/products-by-employee")
    @ResponseStatus(HttpStatus.OK)
    public List<WarehouseResponseDTO> findAllProductByFkEmployeeId(@RequestBody
                                                                   WarehouseByFkEmployeeIdRequestDTO dto) {
        return warehouseServiceImpl.findAllProductByFkEmployeeId(dto);
    }
}
