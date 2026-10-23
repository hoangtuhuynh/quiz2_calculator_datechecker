package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumOfTwoPositiveNumbers() {
        assertEquals(5, calculator.sum(2, 3));
    }

    @Test
    void sumWithNegativeNumbers() {
        assertEquals(-7, calculator.sum(-3, -4));
        assertEquals(1, calculator.sum(-2, 3));
    }

    @Test
    void sumWithZero() {
        assertEquals(4, calculator.sum(4, 0));
        assertEquals(0, calculator.sum(0, 0));
    }

    @Test
    void subtractSmallerFromLarger() {
        assertEquals(6, calculator.subtract(10, 4));
    }

    @Test
    void subtractLargerFromSmallerGivesNegative() {
        assertEquals(-6, calculator.subtract(4, 10));
    }

    @Test
    void multiplyTwoPositiveNumbers() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void multiplyByZeroGivesZero() {
        assertEquals(0, calculator.multiply(7, 0));
        assertEquals(0, calculator.multiply(0, -5));
    }

    @Test
    void multiplyWithNegativeNumbers() {
        assertEquals(-15, calculator.multiply(-3, 5));
        assertEquals(15, calculator.multiply(-3, -5));
    }

    @Test
    void divideEvenly() {
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    void divideReturnsIntegerQuotient() {
        assertEquals(3, calculator.divide(7, 2));
        assertEquals(-3, calculator.divide(-7, 2));
    }

    @Test
    void divideByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void isEvenReturnsTrueForEvenNumbers() {
        assertTrue(calculator.isEven(4), "4 should be even");
        assertTrue(calculator.isEven(0), "0 should be even");
        assertTrue(calculator.isEven(-6), "-6 should be even");
    }

    @Test
    void isEvenReturnsFalseForOddNumbers() {
        assertFalse(calculator.isEven(7), "7 should be odd");
        assertFalse(calculator.isEven(-3), "-3 should be odd");
    }
}
