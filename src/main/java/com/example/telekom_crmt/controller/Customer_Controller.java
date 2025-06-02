package com.example.telekom_crmt.controller;

import com.example.telekom_crmt.model.Customer;
import com.example.telekom_crmt.service.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class Customer_Controller {

    @Autowired
    private Customer_Service CustService;

    @PostMapping()       // To add new customer
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer c){
        Customer savedC=CustService.addCustomer(c);

        return  ResponseEntity.ok(savedC);
    }

    @GetMapping()                // to get all customers
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomers= CustService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> findByEmail(@PathVariable String email){

        Optional<Customer> cust= CustService.findByEmail(email);

        return cust.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteByEmail(@PathVariable String email) {
        CustService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id/{customer_id}")
    public ResponseEntity<Void> deleteById(@PathVariable int customer_id){
        CustService.deleteById(customer_id);
        return ResponseEntity.ok().build();
    }

}
