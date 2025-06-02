package com.example.telekom_crmt.controller;


import com.example.telekom_crmt.model.Product;
import com.example.telekom_crmt.service.Product_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer/product")
public class Product_Controller {

    @Autowired
    Product_Service prodService;

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product p){
        Product temp=prodService.addProduct(p);
        return ResponseEntity.ok(temp);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = prodService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id){
        Optional<Product> temp=prodService.getProductById(id);
        return ResponseEntity.ok(temp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id){

        prodService.deleteById(id);

        return (ResponseEntity) ResponseEntity.ok();
    }

}
