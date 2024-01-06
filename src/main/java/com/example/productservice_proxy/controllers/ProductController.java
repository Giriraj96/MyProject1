package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.springframework.web.bind.annotation.*;
//This Controller will always answer to /products

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public String getAllProducts(){
        return "Getting all the products";
    }

    @GetMapping("/test/{id}") //checking purpose
    public String test(@PathVariable("id") Long productId){
        return "test: "  + productId;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
        Product product = this.productService.getSingleProduct(productId);
        return product;
    }

    @PostMapping("")
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Adding new product : " + productDto;
    }

    @PostMapping("/test") //checking purpose
    public String testPost(@RequestBody ProductDto productDto){
        return "testPost New Product : " + productDto;
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") Long productId){
        return "updating product: " + productId;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long productId){
        return "Deleting product " + productId;
    }
}
