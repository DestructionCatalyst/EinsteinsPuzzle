package com.destructioncatalyst.einsteinspuzzle.model;

import com.destructioncatalyst.einsteinspuzzle.model.logic.DisjunctiveTerm;
import com.destructioncatalyst.einsteinspuzzle.model.logic.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisjunctiveTermTest {

    DisjunctiveTerm first;
    DisjunctiveTerm second;

    @BeforeEach
    void setUp() {
        first = new DisjunctiveTerm();
        second = new DisjunctiveTerm();

        byte[][] b = {
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {3, 4, 0, 0}};
        first.add(new Rule(3, 4, b));

        byte [][] c = {
                {0, 0, 0, 0},
                {0, 4, 0, 0},
                {0, 3, 4, 0}};
        first.add(new Rule(3, 4, c));

        byte [][] d = {
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 0, 3, 4}};
        first.add(new Rule(3, 4, d));

        byte [][] e = {
                {0, 0, 1, 0},
                {0, 0, 3, 1},
                {0, 0, 0, 2}};
        second.add(new Rule(3, 4, e));

        byte [][] f = {
                {0, 0, 1, 0},
                {0, 0, 3, 4},
                {0, 0, 0, 2}};
        second.add(new Rule(3, 4, f));

        byte [][] g = {
                {0, 0, 2, 0},
                {0, 4, 3, 0},
                {0, 0, 4, 0}};
        second.add(new Rule(3, 4, g));

        byte [][] h = {
                {0, 1, 0, 0},
                {0, 3, 4, 0},
                {0, 0, 3, 0}};
        second.add(new Rule(3, 4, h));
    }

    @Test
    void testConjunction() {

        System.out.println(first.conjunction(second));

        assertEquals(first.conjunction(second), second.conjunction(first));

        DisjunctiveTerm expected = new DisjunctiveTerm();

        byte[][] b = {
                {0, 0, 1, 0},
                {0, 4, 3, 1},
                {0, 3, 4, 2}};
        expected.add(new Rule(3, 4, b));

        byte[][] c = {
                {0, 0, 2, 0},
                {0, 4, 3, 0},
                {0, 3, 4, 0}};
        expected.add(new Rule(3, 4, c));

        byte[][] d = {
                {0, 0, 1, 0},
                {4, 0, 3, 1},
                {3, 4, 0, 2}};
        expected.add(new Rule(3, 4, d));

        byte[][] e = {
                {0, 1, 0, 0},
                {0, 3, 4, 0},
                {0, 0, 3, 4}};
        expected.add(new Rule(3, 4, e));

        assertEquals(expected, first.conjunction(second));
    }
}