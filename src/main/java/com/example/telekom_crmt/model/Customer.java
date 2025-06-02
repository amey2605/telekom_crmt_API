package com.example.telekom_crmt.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String customer_firstName;
    private String customer_lastName;
    private String customer_contactNo;
    private String email;
    private String customer_password;
    private String customer_type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address customer_address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "customer_products",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> customer_product=new HashSet<>();


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_firstName='" + customer_firstName + '\'' +
                ", customer_lastName='" + customer_lastName + '\'' +
                ", customer_contactNo=" + customer_contactNo +
                ", email='" + email + '\'' +
                ", customer_password='" + customer_password + '\'' +
                ", customer_type='" + customer_type + '\'' +
                ", customer_address=" + customer_address +
                ", customer_product=" + customer_product +
                '}';
    }



    public Customer() {
    }

    public Customer(int customer_id, String customer_firstName, String customer_lastName, String customer_contactNo, String customer_type, String email, Address customer_address,Set<Product> customer_product,String customer_password) {
        this.customer_id = customer_id;
        this.customer_firstName = customer_firstName;
        this.customer_lastName = customer_lastName;
        this.customer_contactNo = customer_contactNo;
        this.customer_type = customer_type;
        this.email = email;
        this.customer_address = customer_address;
        this.customer_product = customer_product;
        this.customer_password=customer_password;
    }




    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Set<Product> getCustomer_product() {
        return customer_product;
    }

    public void setCustomer_product(Set<Product> customer_product) {
        this.customer_product = customer_product;
    }

    public String getCustomer_firstName() {
        return customer_firstName;
    }

    public void setCustomer_firstName(String customer_firstName) {
        this.customer_firstName = customer_firstName;
    }

    public String getCustomer_lastName() {
        return customer_lastName;
    }

    public void setCustomer_lastName(String customer_lastName) {
        this.customer_lastName = customer_lastName;
    }

    public String getCustomer_contactNo() {
        return customer_contactNo;
    }

    public void setCustomer_contactNo(String customer_contactNo) {
        this.customer_contactNo = customer_contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public Address getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(Address customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }





}
