package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DateCheckerTest {

    @Test
    void januaryHas31Days() {
        DateChecker dateChecker = new DateChecker();
        assertTrue(dateChecker.has31Days(Month.JANUARY), "JANUARY should have 31 days");
    }
}
