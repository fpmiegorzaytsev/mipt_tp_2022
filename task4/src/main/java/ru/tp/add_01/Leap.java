package ru.tp.add_01;

public class Leap {
    public static boolean isLeap(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be greater than 0");
        }
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static int GetMonthDays(int year, int month) {
        if (year == 1930) {
            return 30;
        }
        if (month == 2) {
            if (isLeap(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        if (month > 12 || month <= 0) {
            throw new IllegalArgumentException("Month should be in range [1-12]");
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }
}
