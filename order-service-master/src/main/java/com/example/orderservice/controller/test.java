package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/order")
public class test {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public String placeOrder(OrderRequest orderRequest){


        orderService.placeOrder(orderRequest);
        return "place success";
    }

}
