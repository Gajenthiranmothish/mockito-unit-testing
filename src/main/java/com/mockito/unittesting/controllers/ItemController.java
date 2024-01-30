package com.mockito.unittesting.controllers;

import com.mockito.unittesting.service.ItemBusinessService;
import com.mockito.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 30, 2);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retrieveHardCodedItem();
    }

    @GetMapping("/all-items-from-business-service")
    public List<Item> retrieveAllItems() {
        return itemBusinessService.retrieveAllItems();
    }
}
