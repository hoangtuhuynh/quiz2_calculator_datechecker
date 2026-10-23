package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void subtractSmallerFromLarger() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.subtract(10, 4));
    }

    @Test
    void subtractLargerFromSmallerGivesNegative() {
        Calculator calculator = new Calculator();
        assertEquals(-6, calculator.subtract(4, 10));
    }

    @Test
    void multiplyTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void multiplyByZeroGivesZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.multiply(7, 0));
        assertEquals(0, calculator.multiply(0, -5));
    }

    @Test
    void multiplyWithNegativeNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(-15, calculator.multiply(-3, 5));
        assertEquals(15, calculator.multiply(-3, -5));
    }

    @Test
    void divideEvenly() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.divide(10, 2));
    }

    @Test
    void divideReturnsIntegerQuotient() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.divide(7, 2));
        assertEquals(-3, calculator.divide(-7, 2));
    }

    @Test
    void divideByZeroThrowsException() {
        Calculator calculator = new Calculator();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
