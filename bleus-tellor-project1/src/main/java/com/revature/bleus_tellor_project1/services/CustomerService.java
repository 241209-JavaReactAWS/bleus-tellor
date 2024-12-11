package com.revature.bleus_tellor_project1.services;

import com.revature.bleus_tellor_project1.daos.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public final CustomerDAO customerDAO;
    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
