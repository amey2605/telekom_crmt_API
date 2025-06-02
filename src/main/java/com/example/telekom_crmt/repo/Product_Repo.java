package com.example.telekom_crmt.repo;

import com.example.telekom_crmt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Repo extends JpaRepository<Product,Integer> {

     Product getProductById(int id);
}
