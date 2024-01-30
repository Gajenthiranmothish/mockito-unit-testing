package com.mockito.unittesting.service;

import com.mockito.unittesting.data.ItemRepository;
import com.mockito.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 30, 2);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();
        items = items.stream().map(item -> {
            item.setValue(item.getPrice() * item.getQuantity());
            return item;
        }).collect(Collectors.toList());
        return items;
    }
}
