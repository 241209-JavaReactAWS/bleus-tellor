package com.revature.bleus_tellor_project1.daos;


import com.revature.bleus_tellor_project1.models.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Optional<Customer> getCustomerByUsername(String username);
}
