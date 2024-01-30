package com.mockito.unittesting.controllers;

import com.mockito.unittesting.service.ItemBusinessService;
import com.mockito.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class) //define only classes that you want to be loaded into the spring context here.
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"id\":  1,\n" +
                        "  \"name\": \"Ball\",\n" +
                        "  \"price\": 30\n" +
                        "}")) //It doesnt care even if any json key-value pair not present in json assert, verifies only the pairs given here(you can pass true as a second parameter in json method for strict verification).
                .andReturn();

    }

    @Test
    public void itemFromServiceController_basic() throws Exception {
        when(itemBusinessService.retrieveHardCodedItem())
                .thenReturn(new Item(2, "Fruit", 50, 1));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{ id:  2, name: Fruit, price: 50}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(itemBusinessService.retrieveAllItems())
                .thenReturn(
                        Arrays.asList(
                                new Item(00001, "Item1", 100, 100),
                                new Item(00002, "Item2", 50, 100),
                                new Item(00003, "Item3", 60, 100),
                                new Item(00004, "Item4", 70, 100)
                        )
                );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{ id:  00001, name: Item1, price: 100, quantity: 100}, " +
                                         "{ id:  00002, name: Item2, price: 50, quantity: 100}," +
                                         "{ id:  00003, name: Item3, price: 60, quantity: 100}," +
                                         "{ id:  00004, name: Item4, price: 70, quantity: 100}]"
                        )
                )
                .andReturn();
    }
}
