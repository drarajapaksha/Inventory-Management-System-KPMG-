package com.Inventory_Management_System.Inventory_Management_System.service;

import com.Inventory_Management_System.Inventory_Management_System.dto.ProductDTO;
import com.Inventory_Management_System.Inventory_Management_System.dto.ProductQuantityDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    public String addProduct( ProductDTO productDTO);
    public String updateProduct(ProductQuantityDTO productQuantityDTO);
    public List<ProductDTO> advanceSearch(
             String productName,
            Integer minQuantity,
           Integer maxQuantity,
             Double minPrice,
           Double maxPrice
    );
}
