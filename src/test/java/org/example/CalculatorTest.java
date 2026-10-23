package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void sumOfTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.sum(2, 3));
    }

    @Test
    void sumWithNegativeNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(-7, calculator.sum(-3, -4));
        assertEquals(1, calculator.sum(-2, 3));
    }

    @Test
    void sumWithZero() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.sum(4, 0));
        assertEquals(0, calculator.sum(0, 0));
    }
}
