package com.backend101.marketmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "warehouse")
@Builder
public class WarehouseEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    String id;
    @Column(name = "responsible_person")
    String responsiblePerson;
    @Column(name = "product_no")
    String productNo;
    @Column(name = "product_name")
    String productName;
    @Column(name = "is_active")
    String isActive;
    BigDecimal quantity;
    @Column(name = "product_group")
    String productGroup;
    @Column(name = "product_category")
    String productCategory;
    BigDecimal vat;
    @Column(name = "initial_price")
    BigDecimal initialPrice;
    @Column(name = "exire_date")
    Long expireDate;
    @Column(name = "fk_category_id")
    String fkCategoryId;
    @Column(name = "fk_employee_id")
    String fkEmployeeId;
    @Column(name = "input_date")
    Long inputDate;
}
