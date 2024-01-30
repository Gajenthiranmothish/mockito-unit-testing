package com.mockito.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 13, 64);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItem(13));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(70)));

        assertThat("", isEmptyString());
        assertThat("Gajenthiran", containsString("Gajen"));
        assertThat("Gajenthiran", startsWith("G"));
        assertThat("Gajenthiran", endsWith("ran"));

    }
}
