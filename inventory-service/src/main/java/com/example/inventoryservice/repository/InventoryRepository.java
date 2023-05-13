package com.example.inventoryservice.repository;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.model.Inventory;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query(value = "SELECT i FROM Inventory i WHERE i.skuCode = :skuCode")
    public Inventory findBySkuCode(@Param("skuCode")String skuCode);
    @Query(value = "SELECT i FROM Inventory i WHERE i.skuCode IN :skuCodes")
    public List<Inventory> findBySkuCodeIn(@Param("skuCodes") List<String> skuCodes);

}
