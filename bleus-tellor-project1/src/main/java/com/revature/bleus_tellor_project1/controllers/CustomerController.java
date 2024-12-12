package com.revature.bleus_tellor_project1.controllers;

import com.revature.bleus_tellor_project1.models.Customer;
import com.revature.bleus_tellor_project1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers") // http://localhost:8080/customers
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomerHandler(){
        return customerService.getAllCustomer();
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomerHandler(@RequestBody Customer customer){
        Customer possibleCustomer = customerService.createNewCustomers(customer);
        if (possibleCustomer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(possibleCustomer, HttpStatus.OK);
        }
    }

    @GetMapping("{customerId}") //http://localhost:8080/customers/{customerId}
    public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable int customerID){
        Optional<Customer> possibleCustomer = customerService.getCustomerById(customerID);
        if(possibleCustomer.isPresent()){
            return new ResponseEntity<>(possibleCustomer.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
