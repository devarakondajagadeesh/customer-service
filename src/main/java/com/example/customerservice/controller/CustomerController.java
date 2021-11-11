package com.example.customerservice.controller;

import com.example.customerservice.model.Customer;
import com.example.customerservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private static final Logger LOGGER=LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @PostMapping(path="/customers")
    public Customer CreateCustomer(@RequestBody Customer customer){
        LOGGER.info("createCustomer=  " + "customerfirstName= " + customer.getFirstName()+"customerlastName= " + customer.getLastName());
        return customerService.create(customer);

    }
    @GetMapping(path="/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id){
        LOGGER.info("customerid"+id);
        return customerService.getById(id);
    }
    @GetMapping(path="/customer")
    public List<Customer> getAllCustomer(){
        LOGGER.info("customer");
        return customerService.getAll();
    }
    @PutMapping(path="/customer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.update(customer);
    }
    @DeleteMapping(path="/customers/{id}")
    public void deleteById(@PathVariable int id){
         customerService.deleteById(id);
    }
    @DeleteMapping(path="/customers")
    public void delete(@RequestBody Customer customer){
        customerService.delete(customer);

    }
}
