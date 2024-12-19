package com.revature.bleus_tellor_project1.services;

import com.revature.bleus_tellor_project1.daos.CustomerDAO;
import com.revature.bleus_tellor_project1.daos.ItemDAO;
import com.revature.bleus_tellor_project1.models.Customer;
import com.revature.bleus_tellor_project1.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;
    private final ItemDAO itemDAO;

    @Autowired
    public CustomerService(CustomerDAO customerDAO, ItemDAO itemDAO) {
        this.customerDAO = customerDAO;
        this.itemDAO = itemDAO;
    }

    public List<Customer> getAllCustomer(){
        return customerDAO.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public Optional<Customer> getCustomer(int customerId) {
        return customerDAO.findById(customerId);
    }

    public Optional<Customer> getCustomerByUsername(String userName) {
        Optional<Customer> possibleCustomer = customerDAO.getCustomerByUserName(userName);

        return possibleCustomer;
    }

    public void deleteCustomer(Customer customer) {
        customerDAO.delete(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public Customer loginCustomer(String userName, String password) {
        Optional<Customer> possibleCustomer = customerDAO.getCustomerByUserName(userName);

        if(possibleCustomer.isEmpty()) {
            return null;
        }

        Customer actualCustomer = possibleCustomer.get();

        if(actualCustomer.getCustomerPassword().equals(password)) {
            return actualCustomer;
        }
        
        return null;
    }

    public Customer addItemToCart(String username, int itemId) {
        
        Optional<Customer> possibleCustomer = customerDAO.getCustomerByUserName(username);

        Optional<Item> possibleItem = itemDAO.findById(itemId);

        if(possibleCustomer.isEmpty() || possibleItem.isEmpty()) {
            return null;
        }

        Customer actualCustomer = possibleCustomer.get();
        Item actualItem = possibleItem.get();

        Set<Item> itemsCart = actualCustomer.getItemCart();
        itemsCart.add(actualItem);
        actualCustomer.setItemCart(itemsCart);

        return customerDAO.save(actualCustomer);
    }

    public Customer removeItemFromCart(String username, int itemId) {
        
        Optional<Customer> possibleCustomer = customerDAO.getCustomerByUserName(username);
        Optional<Item> possibleItem = itemDAO.findById(itemId);

        if(possibleCustomer.isEmpty() || possibleItem.isEmpty()) {
            return null;
        }

        Customer actualCustomer = possibleCustomer.get();
        Item acutalItem = possibleItem.get();

        if(!actualCustomer.getItemCart().contains(acutalItem)) {
            return null;
        }

        Set<Item> itemsCart = actualCustomer.getItemCart();
        itemsCart.remove(acutalItem);
        actualCustomer.setItemCart(itemsCart);

        return customerDAO.save(actualCustomer);
    }
}
