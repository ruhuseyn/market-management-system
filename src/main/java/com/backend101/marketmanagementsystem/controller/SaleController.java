package com.backend101.marketmanagementsystem.controller;

import com.backend101.marketmanagementsystem.dto.request.SaleReadRequestDTO;
import com.backend101.marketmanagementsystem.dto.request.SaleRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.SaleReadResponseDTO;
import com.backend101.marketmanagementsystem.service.SaleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/erp/management/sale")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SaleController {

    SaleService saleService;

    @PostMapping("/save")
    public void save(@RequestBody SaleRequestDTO dto){
        saleService.save(dto);
    }

    @PostMapping("/read")
    public List<SaleReadResponseDTO> read(@RequestBody SaleReadRequestDTO dto){
        return saleService.read(dto);
    }
}
