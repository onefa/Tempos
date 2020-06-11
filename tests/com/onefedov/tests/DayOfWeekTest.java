package com.onefedov.tests;

import com.onefodov.DayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DayOfWeekTest {
    @DisplayName("Should calculate the correct date")
    @ParameterizedTest(name = "{index} => day={0}, month={1}, year={2}, Expected Day={3}")
    @CsvSource({
        "24, 8, 1, 1",
        "24, 8, 1001, 1",
        "1, 1, 1, 6",
        "30, 1, 1, 0",
        "1, 3, 5, 2",
        "30, 3, 5, 3",
        "31, 2, 5, 1"
    })
    void successfulTest(int day, int month, int year, int expectedDay) {
        Assertions.assertEquals(expectedDay, DayOfWeek.calculate(day, month, year));
    }

    @DisplayName("Should throw an exception for invalid month")
    @ParameterizedTest(name = "{index} => day={0}, month={1}, year={2}")
    @CsvSource({
            "1, 13, 10"
    })
    void failDateMonthTest(int day, int month, int year) {
        Throwable e = assertThrows(
                IllegalArgumentException.class,
                () -> DayOfWeek.calculate(day, month, year)
        );
        Assertions.assertEquals(String.format("Invalid Month: %d", month), e.getMessage());
    }

    @DisplayName("Should throw an exception for invalid year")
    @ParameterizedTest(name = "{index} => day={0}, month={1}, year={2}")
    @CsvSource({
            "15, 11, 0",
    })
    void failDateYearTest(int day, int month, int year) {
        Throwable e = assertThrows(
                IllegalArgumentException.class,
                () -> DayOfWeek.calculate(day, month, year)
        );
        Assertions.assertEquals(String.format("Invalid Year: %d", year), e.getMessage());
    }

    @DisplayName("Should throw an exception for invalid day")
    @ParameterizedTest(name = "{index} => day={0}, month={1}, year={2}")
    @CsvSource({
            "31, 2, 1",
            "31, 3, 5"
    })
    void failDateDateTest(int day, int month, int year) {
        Throwable e = assertThrows(
                IllegalArgumentException.class,
                () -> DayOfWeek.calculate(day, month, year)
        );
        Assertions.assertEquals(String.format("Invalid Date: %d/%d/%d", day, month, year), e.getMessage());
    }
}