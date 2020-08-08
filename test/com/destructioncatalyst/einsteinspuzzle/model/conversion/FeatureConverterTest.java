package com.destructioncatalyst.einsteinspuzzle.model.conversion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FeatureConverterTest {

    FeatureConverter featureConverter;
    String[] headers;

    @BeforeEach
    void setUp() {

        headers = new String[]{
                "Имя",
                "Цвет"
                //"Обувь"
        };

        String[][] lines = {
                {"Ваня", "Петя", "Маша"},
                {"Желтый", "Зеленый", "Розовый"}
                //{"Ботинки", "Кроссовки", "Туфли"}
        };

        featureConverter = new FeatureConverter(headers, lines);
    }

    @Test
    void testEncode() {

        String[][] lines = {
                {"Маша", "Ваня", "Петя"},
                {"Розовый", "Зеленый", "Желтый"}
                //{"Ботинки", "Кроссовки", "Туфли"}
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

        String[][] expected = {
                {"Ваня", "Маша", "Петя"},
                {"Зеленый", "Розовый", "Желтый"}
                //{"Ботинки", "Кроссовки", "Туфли"}
        };

        assertArrayEquals(expected, featureConverter.decode(numbers));

    }
}