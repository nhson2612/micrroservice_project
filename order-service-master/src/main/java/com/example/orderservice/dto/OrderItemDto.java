package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private int quantity;
}
