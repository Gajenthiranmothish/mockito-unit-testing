package com.mockito.unittesting.data;

import com.mockito.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //It is initialising App context as well
@TestPropertySource("classpath:application.properties")
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void findAll_basic() {
        List<Item> items = itemRepository.findAll();
        assertEquals(4, items.size());
    }
}
