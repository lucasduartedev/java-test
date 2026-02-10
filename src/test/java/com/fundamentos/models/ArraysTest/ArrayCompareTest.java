package com.fundamentos.models.ArraysTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class ArrayCompareTest {

    @Test
    @DisplayName("Compara o conteúdo de array's")
    void test1() {
        int[] numbers = {5, 1, 9, 7, 8};
        int[] expectedArray = {1, 5, 7, 8, 9};

        Arrays.sort(numbers);

        assertArrayEquals(expectedArray, numbers);
    }

    @Test
    @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance() {
        int[] numbers = {5, 1, 9, 7, 8};
        for (int i = 0; i < 100000000; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }

    }
    
}
