package com.Inventory_Management_System.Inventory_Management_System.service.serviceIMPL;

import com.Inventory_Management_System.Inventory_Management_System.dto.ProductDTO;
import com.Inventory_Management_System.Inventory_Management_System.dto.ProductQuantityDTO;
import com.Inventory_Management_System.Inventory_Management_System.entity.Product;
import com.Inventory_Management_System.Inventory_Management_System.repository.ProductRepo;
import com.Inventory_Management_System.Inventory_Management_System.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceIMPL implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceIMPL(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public String addProduct(ProductDTO productDTO) {
        Product product = this.productDtoCastToProductEntity(productDTO);
        this.productRepo.save(product);
        return product.getProductId() + "Id details are saved";
    }

    private Product productDtoCastToProductEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return product;
    }

    @Override
    public String updateProduct(ProductQuantityDTO productQuantityDTO) {
        if (productRepo.existsById(Long.valueOf(productQuantityDTO.getProductId()))) {
            Product product = productRepo.getReferenceById(Long.valueOf(productQuantityDTO.getProductId()));
            product.setQuantity(Integer.parseInt(productQuantityDTO.getQuantity()));
            productRepo.save(product);
            return "saved";
        } else {
            return "Invalid id";
        }

    }

    @Override
    public List<ProductDTO> advanceSearch(String productName, Integer minQuantity, Integer maxQuantity, Double minPrice, Double maxPrice) {
        List<Product> products = new ArrayList<>();
        List<ProductDTO> dtos = new ArrayList<>();
        Integer minQ = 0;
        Integer maxQ=1000000;
        double minP=0;
        double maxP=10000000;
        if (minQuantity!=-1)
         {
            minQ=minQuantity;
        }

        if (maxQuantity!=-1)
        {
            maxQ=maxQuantity;
        }


        if (minPrice!=-1)
        {
            minP=minPrice;
        }

        if (maxPrice!=-1)
        {
            maxP=maxPrice;
        }

        if (productName.equals("any")) {

            products = productRepo.advanceSearchWithoutName(minQ, maxQ, minP, maxP);
        } else {
            products = productRepo.advanceSearchWithName(productName, minQ, maxQ, minP, maxP);
        }
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO(
                    product.getProductName(),
                    product.getQuantity(),
                    product.getPrice()
            );
            dtos.add(productDTO);
        }
        return dtos;
    }

}

