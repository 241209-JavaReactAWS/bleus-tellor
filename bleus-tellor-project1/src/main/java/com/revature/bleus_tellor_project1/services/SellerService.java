package com.revature.bleus_tellor_project1.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bleus_tellor_project1.daos.SellerDAO;
import com.revature.bleus_tellor_project1.models.Seller;

import java.util.List;
import java.util.Optional;


@Service
public class SellerService {
    private final SellerDAO sellerDAO;

    @Autowired
    public SellerService(SellerDAO _sellerDAO) {
        this.sellerDAO = _sellerDAO;
    }

    public Optional<Seller> getSellerById(int _sellerId) {
        return sellerDAO.findById(_sellerId);
    }

    public List<Seller> getAllSellers() {
        return sellerDAO.findAll();
    }

    public Seller createNewSeller(Seller _seller) {
        return sellerDAO.save(_seller);
    }

    public void DeleteSeller(Seller _seller) {
        sellerDAO.delete(_seller);
    }
}
