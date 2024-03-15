package com.backend101.marketmanagementsystem.service;

import com.backend101.marketmanagementsystem.dto.request.WarehouseByFkEmployeeIdRequestDTO;
import com.backend101.marketmanagementsystem.dto.response.WarehouseResponseDTO;
import com.backend101.marketmanagementsystem.entity.OrderEntity;
import com.backend101.marketmanagementsystem.entity.UserEntity;
import com.backend101.marketmanagementsystem.entity.WarehouseEntity;
import com.backend101.marketmanagementsystem.mapper.WarehouseMapper;
import com.backend101.marketmanagementsystem.repository.OrderRepository;
import com.backend101.marketmanagementsystem.repository.UserRepository;
import com.backend101.marketmanagementsystem.repository.WarehouseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WarehouseService {

    WarehouseRepository warehouseRepository;
    WarehouseMapper warehouseMapper;
    MailService mailService;
    OrderRepository orderRepository;
    UserRepository userRepository;

    public List<WarehouseResponseDTO> findAllProduct() {
        return warehouseRepository.findAll().stream()
                .map(warehouseMapper::toWarehouseResponseDto).toList();
    }


    public List<WarehouseResponseDTO> findAllProductByFkEmployeeId(WarehouseByFkEmployeeIdRequestDTO dto) {
        return warehouseRepository.findAllByFkEmployeeId(dto.getFkEmployeeId()).stream()
                .map(warehouseMapper::toWarehouseResponseDto).toList();
    }


    public void save(WarehouseResponseDTO dto) {
        WarehouseEntity entity = warehouseRepository.save(warehouseMapper.toEntity(dto));
        OrderEntity orderEntity = orderRepository.findByFkProductId(entity.getFkProductId());
        UserEntity userEntity = userRepository.findById(orderEntity.getFkUserId()).get();
        userEntity.setId("C");


        if (entity.getQuantity().doubleValue() > 0) {
            mailService.sendMail(userEntity.getEmail(),"klbdvkjbefasjkv qeAS C");
        }
        warehouseRepository.save(entity);
    }
}
