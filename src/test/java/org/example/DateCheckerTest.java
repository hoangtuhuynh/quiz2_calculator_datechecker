package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateCheckerTest {

    @Test
    void januaryHas31Days() {
        DateChecker dateChecker = new DateChecker();
        assertTrue(dateChecker.has31Days(Month.JANUARY), "JANUARY should have 31 days");
    }

    @Test
    void aprilDoesNotHave31Days() {
        DateChecker dateChecker = new DateChecker();
        assertFalse(dateChecker.has31Days(Month.APRIL), "APRIL has only 30 days");
    }

    @ParameterizedTest(name = "{0} has 31 days")
    @EnumSource(value = Month.class,
            names = {"JANUARY", "MARCH", "MAY", "JULY", "AUGUST", "OCTOBER", "DECEMBER"})
    void monthsWith31Days(Month month) {
        DateChecker dateChecker = new DateChecker();
        assertTrue(dateChecker.has31Days(month), month + " should have 31 days");
    }

    @ParameterizedTest(name = "{0} has 30 days")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void monthsWith30Days(Month month) {
        DateChecker dateChecker = new DateChecker();
        assertFalse(dateChecker.has31Days(month), month + " has only 30 days");
    }
}
