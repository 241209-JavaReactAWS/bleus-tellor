package com.revature.bleus_tellor_project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.bleus_tellor_project1.services.SellerService;
import com.revature.bleus_tellor_project1.models.Seller;

@RestController
@RequestMapping("seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService _sellerService) {
        this.sellerService = _sellerService;
    }

    @GetMapping
    public List<Seller> GetAllSellersHandler() {
        return sellerService.getAllSellers();
    }

    // WILL ADD CAPABILITY TO FIND ALL ITEMS BY SELLER LATER, MUST RESEARCH MORE INTO HOW TO CONNECT TABLES

    /* ALSO DONT THINK SELLERS SHOULD BE ABLE TO SEE ALL SELLERS, MAYBE THE CAPABILITY WILL BE USEFUL FOR CUSTOMERS
    JUST CANT SHOW USERNAME AND PASSWORD TO THE CUSTOMERS IF THE ACCESS FIND ALL SELLERS
    *
    *
    *
    *   WILL ADD CUSTOM CONTROLLER FUNCTIONS HERE THAT INVOLVE MULTIPLE TABLES AND FOREIGN KEYS
    *
    *
    *
    *
    */

    
}
