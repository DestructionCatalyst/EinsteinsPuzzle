package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("rawtypes")
class FeatureConverterTest {

    FeatureConverter featureConverter;
    String[] headers;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setUp() {

        headers = new String[]{
                "Имя",
                "Цвет"
                //"Обувь"
        };

        ArrayList[] lines = {
                new ArrayList<>(Arrays.asList("Ваня", "Петя", "Маша")),
                new ArrayList<>(Arrays.asList("Желтый", "Зеленый", "Розовый"))
                //new ArrayList<>(Arrays.asList("Ботинки", "Кроссовки", "Туфли"))
        };

        featureConverter = new FeatureConverter(headers, lines);
    }

    @SuppressWarnings("unchecked")
    @Test
    void testEncode() {

        ArrayList[] lines = {
                new ArrayList<>(Arrays.asList("Маша", "Ваня", "Петя")),
                new ArrayList<>(Arrays.asList("Розовый", "Зеленый", "Желтый"))
                //new ArrayList<>(Arrays.asList("Ботинки", "Кроссовки", "Туфли"))
        };

        byte[][] expected = {
                {3, 1, 2},
                {3, 2, 1}
        };

        assertArrayEquals(expected, featureConverter.encode(lines));
    }

    @Test
    void testDecode() {

        byte[][] numbers = {
                {1, 3, 2},
                {2, 3, 1}
        };

        ArrayList[] expected = {
                new ArrayList<>(Arrays.asList("Ваня", "Маша", "Петя")),
                new ArrayList<>(Arrays.asList("Зеленый", "Розовый", "Желтый"))
                //new ArrayList<>(Arrays.asList("Ботинки", "Кроссовки", "Туфли"))
        };

        assertArrayEquals(expected, featureConverter.decode(numbers));

    }
}