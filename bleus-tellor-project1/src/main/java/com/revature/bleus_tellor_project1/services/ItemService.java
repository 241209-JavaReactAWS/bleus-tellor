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
    public ItemService(ItemDAO _itemDAO) {   
        this.itemDAO = _itemDAO;
    }
    public Optional<Item> getItemById(int _itemId) {
        return itemDAO.findById(_itemId);
    }

    public List<Item> getAllItems() {
        return itemDAO.findAll();
    }

    public List<Item> getItemsBySeller(int _sellerId) {
        return itemDAO.findBySeller_Id(_sellerId);
    }

    public Item createNewItem(Item _item) {
        return itemDAO.save(_item);
    }

    public void deleteItem(Item _item) {
        itemDAO.delete(_item);
    }
}
