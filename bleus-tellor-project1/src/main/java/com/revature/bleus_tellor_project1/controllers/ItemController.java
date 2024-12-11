package com.revature.bleus_tellor_project1.controllers;

import com.revature.bleus_tellor_project1.models.Item;
import com.revature.bleus_tellor_project1.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService _ItemService) {
        this.itemService = _ItemService;
    }

    @GetMapping
    public List<Item> getAllItemsHandler() {
        return itemService.getAllItems();
    }

    @GetMapping("{itemId}")
    public ResponseEntity<Item> getSpecificItemHandler(@PathVariable int itemId) {
        Optional<Item> possibleItem = itemService.getItemById(itemId);

        if(possibleItem.isPresent()) {
            return new ResponseEntity<>(possibleItem.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("seller/{sellerId}")
    public List<Item> getItemsBySellerHandler(@PathVariable int sellerId) {
        return itemService.getItemsBySeller(sellerId);
    }

    @PostMapping("{itemId}")
    public ResponseEntity<Item> createItemHandler(@RequestBody Item _item) {
        Item possibleItem = itemService.createNewItem(_item);

        if(possibleItem == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(possibleItem, HttpStatus.CREATED);
        }
    }

}
