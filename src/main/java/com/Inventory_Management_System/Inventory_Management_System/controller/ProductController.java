package com.Inventory_Management_System.Inventory_Management_System.controller;

import com.Inventory_Management_System.Inventory_Management_System.dto.ProductDTO;
import com.Inventory_Management_System.Inventory_Management_System.dto.ProductQuantityDTO;
import com.Inventory_Management_System.Inventory_Management_System.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public String addProduct(@RequestBody ProductDTO productDTO) {
       return productService.addProduct(productDTO);

    }
    @PutMapping("/update")
    public String updateProduct(@RequestBody ProductQuantityDTO productQuantityDTO) {
        String updateMesaage = productService.updateProduct(productQuantityDTO);
        if (updateMesaage.equals("saved")) {
            return "updated";
        } else {
            return "Invalid id"+productQuantityDTO.getProductId();
        }

    }
    @GetMapping("/advanceSearch")
    public List<ProductDTO> advanceSearch(
            @RequestParam(required = false,defaultValue = "any") String productName,
            @RequestParam(required = false,defaultValue = "-1") Integer minQuantity,
            @RequestParam(required = false,defaultValue = "-1") Integer maxQuantity,
            @RequestParam(required = false,defaultValue = "-1") Double minPrice,
            @RequestParam(required = false,defaultValue = "-1") Double maxPrice
    )
    {
        return productService.advanceSearch(productName,minQuantity,maxQuantity,minPrice,maxPrice);

    }

}
