package com.revature.bleus_tellor_project1.daos;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.bleus_tellor_project1.models.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item, Integer> {

}
