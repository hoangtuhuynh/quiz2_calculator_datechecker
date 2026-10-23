package org.example;

import org.junit.jupiter.api.Test;

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
}
