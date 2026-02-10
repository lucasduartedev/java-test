package com.fundamentos.models.ArraysTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayCompareTest {

    @Test
    @DisplayName("Compara o conteúdo de array's")
    void test1() {
        int[] numbers = {5, 1, 9, 7, 8};
        int[] expectedArray = {1, 5, 7, 8, 9};

        Arrays.sort(numbers);

        assertArrayEquals(expectedArray, numbers);
    }
    
}
