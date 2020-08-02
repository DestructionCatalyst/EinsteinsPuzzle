package com.destructioncatalyst.einsteinspuzzle.model;

import com.destructioncatalyst.einsteinspuzzle.model.logic.DisjunctiveTerm;
import com.destructioncatalyst.einsteinspuzzle.model.logic.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    Rule first;

    @BeforeEach
    void setUp() {

        byte[][] b = {{0, 0, 0, 0},
                      {0, 4, 0, 0},
                      {0, 3, 4, 0}};
        first = new Rule(3, 4, b);
    }

    @Test
    void testConjunctionSuccess() {

        byte[][] c = {{0, 0, 1, 0}, {0, 0, 3, 1}, {0, 0, 0, 2}};
        Rule second = new Rule(3, 4, c);

        Rule res = first.conjunction(second);

        assertEquals(res, second.conjunction(first));

        byte[][] expected = {{0, 0, 1, 0}, {0, 4, 3, 1}, {0, 3, 4, 2}};

        assertEquals(res, new Rule(3, 4, expected));
    }

    @Test
    void testConjunctionOverlapSuccess(){

        byte[][] c = {{0, 2, 0, 0}, {0, 4, 3, 0}, {0, 0, 4, 0}};
        Rule second = new Rule(3, 4, c);

        Rule res = first.conjunction(second);

        assertEquals(res, second.conjunction(first));

        byte[][] expected = {{0, 2, 0, 0}, {0, 4, 3, 0}, {0, 3, 4, 0}};

        assertEquals(res, new Rule(3, 4, expected));
    }

    @Test
    void testConjunctionRepeatFailure(){

        byte[][] c = {{0, 0, 1, 0}, {0, 0, 3, 4}, {0, 0, 0, 2}};
        Rule second = new Rule(3, 4, c);

        Rule res = first.conjunction(second);

        assertEquals(res, second.conjunction(first));

        assertNull(res);

    }

    @Test
    void testConjunctionOverlapFailure(){

        byte[][] c = {{0, 1, 0, 0}, {0, 3, 4, 0}, {0, 0, 2, 0}};
        Rule second = new Rule(3, 4, c);

        Rule res = first.conjunction(second);

        assertEquals(res, second.conjunction(first));

        assertNull(res);
    }


    @Test
    void testGenerateShifts() {

        DisjunctiveTerm shifts = first.generateShifts();

        DisjunctiveTerm expected = new DisjunctiveTerm();

        byte[][] b = {
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {3, 4, 0, 0}};
        expected.add(new Rule(3, 4, b));

        byte [][] c = {
                {0, 0, 0, 0},
                {0, 4, 0, 0},
                {0, 3, 4, 0}};
        expected.add(new Rule(3, 4, c));

        byte [][] d = {
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 0, 3, 4}};
        expected.add(new Rule(3, 4, d));

        System.out.println(shifts);

        assertEquals(expected, shifts);
    }

    @Test
    void testEmptyShifts() {

        byte [][] zeros = {
                {0, 0},
                {0, 0}};

        Rule empty = new Rule(2, 2, zeros);

        DisjunctiveTerm shifts = empty.generateShifts();

        DisjunctiveTerm expected = new DisjunctiveTerm();

        assertEquals(shifts, expected);
    }

    @Test
    void testSplitControversial() {

        byte [][] d = {
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 1, 0, 1}};
        Rule controversial = new Rule(3, 4, d);

        DisjunctiveTerm generated = controversial.splitControversial();

        //System.out.println(generated);

        DisjunctiveTerm expected = new DisjunctiveTerm();

        byte [][] e = {
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 1, 0, 0}};

        expected.add(new Rule(3, 4, e));

        byte [][] f = {
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {0, 0, 0, 1}};

        expected.add(new Rule(3, 4, f));

        assertEquals(expected, generated);
    }
}