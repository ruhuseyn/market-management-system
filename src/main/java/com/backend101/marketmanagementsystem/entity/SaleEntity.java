package com.backend101.marketmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sale")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    String id;
    @Column(name = "product_name")
    String productName;
    @Column(name = "delivery_date")
    Long deliveryDate;
    @Column(name = "payment_date")
    Long paymentDate;
    BigDecimal quantity;
    String unit;
    BigDecimal vat;
    BigDecimal price;
    @Column(name = "total_price")
    BigDecimal totalPrice;
    @Column(name = "fk_product_id")
    String fkProductId;
    @Column(name = "fk_warehouse_id")
    String fkWarehouseId;
    String productCategory;
}
