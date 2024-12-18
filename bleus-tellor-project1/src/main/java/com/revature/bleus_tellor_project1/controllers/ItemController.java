package com.revature.bleus_tellor_project1.controllers;

import com.revature.bleus_tellor_project1.models.Customer;
import com.revature.bleus_tellor_project1.models.Item;
import com.revature.bleus_tellor_project1.models.Role;
import com.revature.bleus_tellor_project1.services.ItemService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("items")
@CrossOrigin(origins = "https://localhost:5173", allowCredentials = "true")
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

        if(possibleItem.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(304).body(possibleItem.get());
    }


    @PostMapping("{itemId}")
    public ResponseEntity<Item> createItemHandler(HttpSession session, @RequestBody Item item) {

        if(session.isNew() || session.getAttribute("username") == null) {
            return ResponseEntity.status(401).build();
        }

        if(session.getAttribute("role") != Role.ADMIN) {
            return ResponseEntity.status(403).build();
        }

        Item actualItem = itemService.createNewItem(item);

        if(actualItem == null) {
            return ResponseEntity.badRequest().build();
        } 
        
        return ResponseEntity.status(201).body(actualItem);
        
    }

    @PutMapping("{itemId}")
    public ResponseEntity<Item> updateItemHandler(HttpSession session, @RequestBody int itemId) {
        if(session.isNew() || session.getAttribute("username") == null) {
            return ResponseEntity.status(401).build();
        }

        if(session.getAttribute("role") != Role.ADMIN) {
            return ResponseEntity.status(403).build();
        }

        Optional<Item> possibleItem = itemService.getItemById(itemId);
        
        if(possibleItem.isEmpty()) {
            return ResponseEntity.status(304).build();
        }

        return ResponseEntity.status(204).body(possibleItem.get());
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Item> deleteItemHandler(HttpSession session, @PathVariable int itemId) {
        if (session.isNew() || session.getAttribute("username") == null) {
            return ResponseEntity.status(401).build();
        }

        if(session.getAttribute("role") != Role.ADMIN) {
            return ResponseEntity.status(403).build();
        }

        Optional<Item> possibleItem = itemService.getItemById(itemId);

        if(possibleItem.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        itemService.deleteItem(possibleItem.get());

        return ResponseEntity.status(204).body(possibleItem.get());


    }
}
