package com.example.telekom_crmt.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product_name;
    private int product_price;
    private String product_type;
    private boolean isProductAvailable;

    @ManyToMany(mappedBy = "customer_product")
    private Set<Customer> customers = new HashSet<>();

    public Product() {}

    public Product(String product_name, int product_price, String product_type, boolean isProductAvailable) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_type = product_type;
        this.isProductAvailable = isProductAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public boolean isProductAvailable() {
        return isProductAvailable;
    }

    public void setProductAvailable(boolean productAvailable) {
        isProductAvailable = productAvailable;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                ", product_type='" + product_type + '\'' +
                ", isProductAvailable=" + isProductAvailable +
                '}';
    }
}
