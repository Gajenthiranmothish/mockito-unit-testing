package com.mockito.unittesting.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void retrieveAllItems_basic() throws JSONException {
        String expected = "[{id: 0001}, {id: 0002}, {id: 0003}, {id: 0004}]";
        String response = restTemplate.getForObject("/all-items-from-business-service", String.class);
        JSONAssert.assertEquals(expected, response, false);
    }
}
