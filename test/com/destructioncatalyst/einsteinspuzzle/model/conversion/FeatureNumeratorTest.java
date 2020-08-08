package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FeatureNumeratorTest {

    FeatureNumerator numerator;

    @BeforeEach
    void setUp() {
        String[] features = {"One", "Two", "Three", "Four", "Five"};
        numerator = new FeatureNumerator(features);
    }

    @Test
    void testDecodeLine() {

        byte[] line = {5, 2, 3, 1, 4};
        String[] expected = {"Five", "Two", "Three", "One", "Four"};

        assertArrayEquals(expected, numerator.decodeLine(line));
    }

    @Test
    void testDecodeLineWithZeros() {

        byte[] line = {0, 3, 0, 1, 0};
        String[] expected = {"", "Three", "", "One", ""};

        assertArrayEquals(expected, numerator.decodeLine(line));
    }

    @Test
    void testEncodeLine() {

        byte[] expected = {5, 2, 3, 1, 4};
        String[] line = {"Five", "Two", "Three", "One", "Four"};

        assertArrayEquals(expected, numerator.encodeLine(line));
    }

    @Test
    void testEncodeLineWithZeros() {

        byte[] expected = {0, 3, 0, 1, 0};
        String[] line = {"", "Three", "", "One", ""};

        assertArrayEquals(expected, numerator.encodeLine(line));
    }

    @Test
    void testCheckRepeat() {
        String[] line = {"One", "Three", "Two", "One", "Four"};

        assertThrows(IllegalArgumentException.class,
                ()-> new FeatureNumerator(line)
        );
    }

    @Test
    void testCheckEmpty() {
        String[] line = {"One", "Three", "Two", "", "Four"};

        assertThrows(IllegalArgumentException.class,
                ()-> new FeatureNumerator(line)
        );
    }
}