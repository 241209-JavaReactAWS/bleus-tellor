package com.revature.bleus_tellor_project1.daos;

import com.revature.bleus_tellor_project1.models.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {
    
    List<Item> findBySeller_Id(int sellerId);
}
