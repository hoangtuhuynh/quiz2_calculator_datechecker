package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateCheckerTest {

    private DateChecker dateChecker;

    @BeforeEach
    void setUp() {
        dateChecker = new DateChecker();
    }

    @ParameterizedTest(name = "{0} has 31 days")
    @EnumSource(value = Month.class,
            names = {"JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER"})
    void monthsWith31Days(Month month) {
        assertTrue(dateChecker.has31Days(month), month + " should have 31 days");
    }

    @ParameterizedTest(name = "{0} has 30 days")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void monthsWith30Days(Month month) {
        assertFalse(dateChecker.has31Days(month), month + " has only 30 days");
    }

    @Test
    void februaryDoesNotHave31Days() {
        assertFalse(dateChecker.has31Days(Month.FEBRUARY),
                "FEBRUARY has 28 or 29 days, never 31");
    }

    @Test
    void nullMonthThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> dateChecker.has31Days(null));
        assertEquals("Month must not be null", exception.getMessage());
    }
}
