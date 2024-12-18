package com.revature.bleus_tellor_project1.services;

import com.revature.bleus_tellor_project1.daos.CustomerDAO;
import com.revature.bleus_tellor_project1.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // get customer by ID Method
    public Optional<Customer> getCustomerById(int customerID){
        return customerDAO.findById(customerID);
    }

    //get all customer method
    public List<Customer> getAllCustomer(){
        return customerDAO.findAll();
    }
    //Create customer Method
    public Customer createNewCustomers(Customer customers){
         if(customers.getPurchaseAmount() < 0){
             return null;
         }
         return customerDAO.save(customers);
    }

    public Customer loginCustomer(String userName, String password) {
        Optional<Customer> possibleCustomer = customerDAO.get
        
        return null;
    }
}
