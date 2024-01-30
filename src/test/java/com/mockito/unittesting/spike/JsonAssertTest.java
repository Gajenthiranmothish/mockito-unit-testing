package com.mockito.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\n" +
            "  \"id\": 1,\n" +
            "  \"name\": \"Ball\",\n" +
            "  \"price\": 30,\n" +
            "  \"quantity\": 2\n" +
            "}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptSpaces() throws JSONException {
        String expectedResponse = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Ball\",\n" +
                "  \"price\": 30,\n" +
                "  \"quantity\": 2\n" +
                "}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalseExceptSpaces() throws JSONException {
        String expectedResponse = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Ball\",\n" +
                "  \"price\": 30\n" +
                "}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_withoutEscapeSequence() throws JSONException {
        String expectedResponse = "{id: 1, name: \"Ball \",price: 30,quantity: 2}"; //remove space next to "Ball" and try
        JSONAssert.assertNotEquals(expectedResponse, actualResponse, true);
    }
}
