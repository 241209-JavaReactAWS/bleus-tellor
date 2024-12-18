package com.revature.bleus_tellor_project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.bleus_tellor_project1.daos.ItemDAO;
import com.revature.bleus_tellor_project1.models.Item;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService {
    private final ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {   
        this.itemDAO = itemDAO;
    }


    public Optional<Item> getItemById(int itemId) {
        return itemDAO.findById(itemId);
    }

    public List<Item> getAllItems() {
        return itemDAO.findAll();
    }

    public Item createNewItem(Item item) {
        return itemDAO.save(item);
    }

    public void deleteItem(Item item) {
        itemDAO.delete(item);
    }

    public Item updateItem(Item item) {
        return itemDAO.save(item);
    }
}
