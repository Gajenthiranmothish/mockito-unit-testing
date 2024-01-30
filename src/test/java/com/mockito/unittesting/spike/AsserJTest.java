package com.mockito.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AsserJTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 13, 64);

        //assertThat(numbers, hasSize(3));
        //assertThat(numbers, hasItem(13));
        //assertThat(numbers, everyItem(greaterThan(10)));
        //assertThat(numbers, everyItem(lessThan(70)));\

        assertThat(numbers)
                .hasSize(3)
                .contains(64)
                .allMatch(n -> n > 11)
                .allMatch(n -> n < 65)
                .noneMatch(n -> n > 65);

        //assertThat("", isEmptyString());
        //assertThat("Gajenthiran", containsString("Gajen"));
        //assertThat("Gajenthiran", startsWith("G"));
        //assertThat("Gajenthiran", endsWith("ran"));

        assertThat("").isEmpty();
        assertThat("Gajenthiran")
                .startsWith("Gajen")
                .endsWith("ran")
                .contains("ran")
                .doesNotContain("M");

    }
}
