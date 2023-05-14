//package com.example.orderservice.feignclient;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.orderservice.dto.InventoryResponse;
//
//@FeignClient(name = "inventory-service", path = "", url = "http://localhost:8080")
//@RibbonClient(name = "inventory-service") // load balancing
//public interface InventoryClient {
//	@GetMapping("/inventory")
//	List<InventoryResponse> getInventories(@RequestParam(name = "sku-code") List<String> skuCode);
//}
