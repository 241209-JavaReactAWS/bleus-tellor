package com.revature.bleus_tellor_project1.controllers;

import com.revature.bleus_tellor_project1.models.Customer;
import com.revature.bleus_tellor_project1.models.Role;
import com.revature.bleus_tellor_project1.services.CustomerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers") // http://localhost:8080/customers
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomerHandler(HttpSession session){
                
        // if(session.getAttribute("role") != Role.ADMIN) {
        //     return null;
        // }
        return customerService.getAllCustomer();
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> customerLoginHandler(@RequestBody Customer customer, HttpSession session) {
        
        Customer actualCustomer = customerService.loginCustomer(customer.getUserName(), customer.getCustomerPassword());

        if(actualCustomer == null) {
            return ResponseEntity.badRequest().build();
        }

        session.setAttribute("username", actualCustomer.getUserName());
        session.setAttribute("userId", actualCustomer.getCustomerId());
        session.setAttribute("role", actualCustomer.getRole());
        
        return ResponseEntity.ok(actualCustomer);

    }

    @PostMapping("/logout")
    public ResponseEntity<?> customerLogoutHandler(HttpSession session) {
        session.invalidate();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/itemCart/{itemId}")
    public ResponseEntity<Customer> addItemToCartHandler(HttpSession session, @PathVariable int itemId) {

        if(session.isNew() || session.getAttribute("username") == null) {
            return ResponseEntity.status(401).build();
        }

        Customer actualCustomer = customerService.addItemToCart((String) session.getAttribute("username"), itemId);

        if(actualCustomer == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(actualCustomer);
    }

    @DeleteMapping("/itemCart/{itemId}")
    public ResponseEntity<Customer> deleteItemFromCartHandler(HttpSession session, @PathVariable int itemId) {
        if(session.isNew() || session.getAttribute("username") == null) {
            return ResponseEntity.status(401).build();
        }

        Customer actualCustomer = customerService.removeItemFromCart((String) session.getAttribute("username"), itemId);

        if(actualCustomer == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(actualCustomer);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<Customer> createCustomerHandler(@RequestBody Customer customer) {

        Customer tempCustomer = customer;

        if(customer.getCustomerPassword() == "adminpass")
        {
            tempCustomer.setRole(Role.ADMIN);
            
        } 
        
        tempCustomer.setRole(Role.CUSTOMER);

        
        return ResponseEntity.status(200).body(customerService.createCustomer(tempCustomer));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer, HttpSession session) {

        Optional<Customer> possibleCustomer = customerService.getCustomer(customer.getCustomerId());

        if(possibleCustomer.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        

        if(session.getAttribute("role") != Role.ADMIN) {
            return ResponseEntity.status(403).build();
        }

        Customer actualCustomer = customerService.updateCustomer(customer);

        return ResponseEntity.status(200).body(actualCustomer);
    }

    @GetMapping("/myAccount")
    public ResponseEntity<Customer> getCustomerHandler(HttpSession session) {

        if (session.isNew() || session.getAttribute("username") == null) {
            return ResponseEntity.status(401).build();
        }

        Optional<Customer> possibleCustomer = customerService.getCustomerByUsername((String) session.getAttribute("userName"));

        if(possibleCustomer.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(possibleCustomer.get());
    }
}
