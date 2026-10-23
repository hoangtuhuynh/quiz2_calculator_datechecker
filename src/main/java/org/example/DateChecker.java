package org.example;

import java.util.EnumSet;
import java.util.Set;

public class DateChecker {

    private static final Set<Month> MONTHS_WITH_31_DAYS = EnumSet.of(
            Month.JANUARY, Month.MARCH, Month.MAY, Month.JULY,
            Month.AUGUST, Month.OCTOBER, Month.DECEMBER);

    /**
     * Returns true if the month always has 31 days.
     * FEBRUARY returns false: it has 28 or 29 days, so it never has 31.
     *
     * @throws IllegalArgumentException if month is null
     */
    public boolean has31Days(Month month) {
        if (month == null) {
            throw new IllegalArgumentException("Month must not be null");
        }
        return MONTHS_WITH_31_DAYS.contains(month);
    }
}
