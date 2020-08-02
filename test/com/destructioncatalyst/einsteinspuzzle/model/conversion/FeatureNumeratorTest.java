package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FeatureNumeratorTest {

    FeatureNumerator numerator;

    @BeforeEach
    void setUp() {
        ArrayList<String> features = new ArrayList<>(
                Arrays.asList("One", "Two", "Three", "Four", "Five"));
        numerator = new FeatureNumerator(features);
    }

    @Test
    void testDecodeLine() {

        byte[] line = {5, 2, 3, 1, 4};
        ArrayList<String> expected = new ArrayList<>(
                Arrays.asList("Five", "Two", "Three", "One", "Four")
        );

        assertEquals(expected, numerator.decodeLine(line));
    }

    @Test
    void testDecodeLineWithZeros() {

        byte[] line = {0, 3, 0, 1, 0};
        ArrayList<String> expected = new ArrayList<>(
                Arrays.asList("", "Three", "", "One", "")
        );

        assertEquals(expected, numerator.decodeLine(line));
    }

    @Test
    void testEncodeLine() {

        byte[] expected = {5, 2, 3, 1, 4};
        ArrayList<String> line = new ArrayList<>(
                Arrays.asList("Five", "Two", "Three", "One", "Four")
        );

        assertArrayEquals(expected, numerator.encodeLine(line));
    }

    @Test
    void testEncodeLineWithZeros() {

        byte[] expected = {0, 3, 0, 1, 0};
        ArrayList<String> line = new ArrayList<>(
                Arrays.asList("", "Three", "", "One", "")
        );

        assertArrayEquals(expected, numerator.encodeLine(line));
    }

    @Test
    void testCheckRepeat() {
        ArrayList<String> line = new ArrayList<>(
                Arrays.asList("One", "Three", "Two", "One", "Four")
        );

        assertThrows(IllegalArgumentException.class,
                ()-> new FeatureNumerator(line)
        );
    }

    @Test
    void testCheckEmpty() {
        ArrayList<String> line = new ArrayList<>(
                Arrays.asList("One", "Three", "Two", "", "Four")
        );

        assertThrows(IllegalArgumentException.class,
                ()-> new FeatureNumerator(line)
        );
    }
}