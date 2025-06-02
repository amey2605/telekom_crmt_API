package com.example.telekom_crmt.service;

import com.example.telekom_crmt.model.Customer;
import com.example.telekom_crmt.model.Product;
import com.example.telekom_crmt.repo.Customer_Repo;
import com.example.telekom_crmt.repo.Product_Repo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Customer_Service {

    @Autowired
    private Customer_Repo custRepo;

    @Autowired
    private Product_Repo prodRepo;

    public Customer addCustomer(Customer c){          // to add customer in customer db
        custRepo.save(c);
        return c;
    }
    public List<Customer> getAllCustomers(){ // get all customers

        return custRepo.findAll();
    }

    public Optional< Customer> findByEmail(String email){ // find customer by email
        return custRepo.findByEmail(email);
    }

    @Transactional
    public Product deleteByEmail(String email){    //delete by email
        Product temp=custRepo.deleteByEmail(email);
        return temp;
    }


    public void updateCustomer(int id,Customer updatedC){   //update customer
        custRepo.findById(id).map(
                c-> {
                    c.setCustomer_contactNo(updatedC.getCustomer_contactNo());
                    c.setEmail(updatedC.getEmail());
                    c.setCustomer_address(updatedC.getCustomer_address());

                    return custRepo.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }


}
