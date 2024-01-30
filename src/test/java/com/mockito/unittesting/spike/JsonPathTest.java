package com.mockito.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    public void learning() {
        String json = "[{ \"id\" : 1, \"name\" : \"Pen\", \"quantity\" : 15 },\n" +
                "{ \"id\" : 2, \"name\" : \"Pencil\", \"quantity\" : 25 },\n" +
                "{ \"id\" : 3, \"name\" : \"Eraser\", \"quantity\" : 20 }]";

        DocumentContext  context = JsonPath.parse(json);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1, 2, 3);
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("[?(@.name=='Pen')]").toString());
        System.out.println(context.read("[?(@.id==3)]").toString());
//        System.out.println(ids);
    }


}

