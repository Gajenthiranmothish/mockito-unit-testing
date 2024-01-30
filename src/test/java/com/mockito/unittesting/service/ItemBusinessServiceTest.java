package com.mockito.unittesting.service;

import com.mockito.unittesting.data.ItemRepository;
import com.mockito.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService itemBusinessService;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllItemsTest_basic() {
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(
                    new Item(00001, "Item1", 100, 100),
                    new Item(00002, "Item2", 50, 100),
                    new Item(00003, "Item3", 60, 100),
                    new Item(00004, "Item4", 70, 100)
        ));
        List<Item> items = itemBusinessService.retrieveAllItems();
        assertEquals(10000, items.get(0).getValue());
        assertEquals(5000, items.get(1).getValue());
        assertEquals(6000, items.get(2).getValue());
        assertEquals(7000, items.get(3).getValue());
    }
}


