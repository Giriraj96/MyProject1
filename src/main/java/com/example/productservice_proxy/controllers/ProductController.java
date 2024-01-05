package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;
//This Controller will always answer to /products

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("")
    public String getAllProducts(){
        return "Getting all the products";
    }

    @GetMapping("/test/{id}") //checking purpose
    public String test(@PathVariable("id") Long productId){
        return "test: "  + productId;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long productId){
        return "Getting single product with id: " + productId;
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
