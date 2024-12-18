package com.revature.bleus_tellor_project1.controllers;

import com.revature.bleus_tellor_project1.models.Customer;
import com.revature.bleus_tellor_project1.services.CustomerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers") // http://localhost:8080/customers
@CrossOrigin(origins = "http://localhost:5170", allowCredentials = "true")
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

    // @PostMapping
    // public ResponseEntity<Customer> createCustomerHandler(@RequestBody Customer customer){
    //     Customer possibleCustomer = customerService.createNewCustomers(customer);
    //     if (possibleCustomer == null){
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }else{
    //         return new ResponseEntity<>(possibleCustomer, HttpStatus.OK);
    //     }
    // }

    // @GetMapping("{customerId}") //http://localhost:8080/customers/{customerId}
    // public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable int customerID){
    //     Optional<Customer> possibleCustomer = customerService.getCustomerById(customerID);
    //     if(possibleCustomer.isPresent()){
    //         return new ResponseEntity<>(possibleCustomer.get(), HttpStatus.OK);
    //     }else{
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }

    // }
}
