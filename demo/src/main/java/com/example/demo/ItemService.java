package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get item by ID
    public Object getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    // Add a new item
    public Item addItem(Item newItem) {
        return itemRepository.save(newItem);
    }

    // Update an existing item
    public Item updateItem(Long id, Item updatedItem) {
        // Check if the item exists
        if (itemRepository.existsById(id)) {
            updatedItem.setId(id);
            return itemRepository.save(updatedItem);
        } else {
            return null; // Handle the case where the item with the given ID doesn't exist
        }
    }

    // Delete an item by ID
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}

