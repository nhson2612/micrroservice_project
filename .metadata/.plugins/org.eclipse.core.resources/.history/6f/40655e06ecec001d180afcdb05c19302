package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
@Entity
public class Order {
    @Id
    private long id;
    @Column(name = "order_number")
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;
}
