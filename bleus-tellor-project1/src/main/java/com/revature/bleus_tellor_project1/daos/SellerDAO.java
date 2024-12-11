package com.revature.bleus_tellor_project1.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.bleus_tellor_project1.models.Seller;

@Repository
public interface SellerDAO extends JpaRepository<Seller, Integer>{

    
}
