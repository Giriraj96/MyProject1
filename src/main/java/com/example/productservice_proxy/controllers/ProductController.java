package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//This Controller will always answer to /products

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(){
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type","application/json");
        headers.add("Accept","application/json");
        headers.add("User-Agent","Mozilla/5.0");
        try {
            List<Product> products = this.productService.getAllProducts();
            ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products,headers, HttpStatus.OK);
            return responseEntity;
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId){
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type","application/json");
        headers.add("Accept","application/json");
        headers.add("User-Agent","Mozilla/5.0");
        headers.add("Host","fakestoreapi.com");
        headers.add("AuthToken","1234567890");
        try {
            Product product = this.productService.getSingleProduct(productId);
            if(productId < 1) {
                throw  new IllegalArgumentException("Product Id cannot be less than 1");
            }
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);
            return responseEntity;
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type","application/json");
        headers.add("Accept","application/json");
        try {
            Product product = this.productService.addNewProduct(productDto);
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers, HttpStatus.CREATED);
            return responseEntity;
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
