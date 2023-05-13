package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.feignclient.InventoryClient;
import com.example.orderservice.model.Orders;
import com.example.orderservice.model.OrderItem;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient webClient;
    @Autowired
    private InventoryClient client;
    
    public void placeOrder(OrderRequest orderRequest) {
    	Orders order = new Orders();
    	order.setOrderNumber(UUID.randomUUID().toString());
    	List<OrderItem> orderItems = orderRequest.getOrderItemDtoList().stream().map(this::mapToOrderItem).toList();
    	order.setOrderItemList(orderItems);
    	List<String> skuCodes = orderItems.stream().map(OrderItem::getSkuCode).collect(Collectors.toList());
    	List<InventoryResponse> inventoryResponses = webClient.get()
    			.uri("http://localhost:8080/inventory",skuCodes)
    			.retrieve()
    			.bodyToFlux(InventoryResponse.class)
    			.collectList()
    			.block();
    	boolean hasFalse = inventoryResponses.stream().allMatch(inventoryResponse->!inventoryResponse.isStock());
    	if(hasFalse) {
    		orderRepository.save(order);
    	}else throw new IllegalAccessError("Có 1 Item stock");
    }
    private OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setSkuCode(orderItemDto.getSkuCode());
        return orderItem;
    }
}
