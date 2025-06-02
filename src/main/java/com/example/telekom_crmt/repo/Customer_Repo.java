package com.example.telekom_crmt.repo;

import com.example.telekom_crmt.model.Customer;
import com.example.telekom_crmt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Customer_Repo extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmail(String email);
    Product deleteByEmail(String email);
}
