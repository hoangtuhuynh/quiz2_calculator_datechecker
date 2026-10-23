package org.example;

public class DateChecker {

    public boolean has31Days(Month month) {
        if (month == null) {
            throw new IllegalArgumentException("Month must not be null");
        }
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return true;
            default:
                return false;
        }
    }
}
