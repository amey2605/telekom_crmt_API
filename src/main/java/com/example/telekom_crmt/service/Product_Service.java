package com.example.telekom_crmt.service;

import com.example.telekom_crmt.model.Product;
import com.example.telekom_crmt.repo.Product_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Product_Service {

    @Autowired
    private Product_Repo prodRepo;

    public Product addProduct(Product p){
        prodRepo.save(p);
        return p;
    }

    public List<Product> getAllProducts(){
        return prodRepo.findAll();
    }

    public Optional<Product> getProductById(int id){
        return prodRepo.findById(id);
    }

    public void deleteById(int id){
         prodRepo.deleteById(id);


    }

}
