import org.junit.jupiter.api.Assertions;
import java.lang.IllegalArgumentException;

import static org.junit.jupiter.api.Assertions.assertThrows;


class DayOfWeekTest {

    @org.junit.jupiter.api.Test
    void calculate240801() {
        int calcRes = DayOfWeek.calculate(24,8,1);
        int checkDayOfWeek = 1;
        Assertions.assertEquals(checkDayOfWeek,calcRes);
    }

    @org.junit.jupiter.api.Test
    void calculate24081001() {
        int calcRes = DayOfWeek.calculate(24,8,1001);
        int checkDayOfWeek = 1;
        Assertions.assertEquals(checkDayOfWeek,calcRes);
    }

    @org.junit.jupiter.api.Test
    void calculate010101() {
        int calcRes = DayOfWeek.calculate(1,1,1);
        int checkDayOfWeek = 6;
        Assertions.assertEquals(checkDayOfWeek,calcRes);
    }

    @org.junit.jupiter.api.Test
    void calculate300101() {
        int calcRes = DayOfWeek.calculate(30, 1, 1);
        int checkDayOfWeek = 0;
        Assertions.assertEquals(checkDayOfWeek, calcRes);
    }

    @org.junit.jupiter.api.Test
    void calculate010305() {
        int calcRes = DayOfWeek.calculate(1, 3, 5);
        int checkDayOfWeek = 2;
        Assertions.assertEquals(checkDayOfWeek, calcRes);
    }
    @org.junit.jupiter.api.Test
    void calculate300305() {
        int calcRes = DayOfWeek.calculate(30, 3, 5);
        int checkDayOfWeek = 3;
        Assertions.assertEquals(checkDayOfWeek, calcRes);
    }

    @org.junit.jupiter.api.Test
    void calculate310205() {
        int calcRes = DayOfWeek.calculate(31, 2, 5);
        int checkDayOfWeek = 1;
        Assertions.assertEquals(checkDayOfWeek, calcRes);
    }



    @org.junit.jupiter.api.Test
    void calculateInvalidYear0() throws IllegalArgumentException{
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            DayOfWeek.calculate(15, 11, 0);
        });
        Assertions.assertEquals("Invalid Year: 0", e.getMessage());

    }

    @org.junit.jupiter.api.Test
    void calculateInvalidMonth13() throws IllegalArgumentException{
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            DayOfWeek.calculate(1, 13, 10);
        });
        Assertions.assertEquals("Invalid Month: 13", e.getMessage());

    }

    @org.junit.jupiter.api.Test
    void calculateInvalidNonLeap31feb() throws IllegalArgumentException{
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            DayOfWeek.calculate(31, 2, 1);
        });
        Assertions.assertEquals("Invalid Date: 31/2/1", e.getMessage());

    }

    @org.junit.jupiter.api.Test
    void calculateInvalidDate310305() throws IllegalArgumentException{
        Throwable e = assertThrows(IllegalArgumentException.class, () -> {
            DayOfWeek.calculate(31, 3, 5);
        });
        Assertions.assertEquals("Invalid Date: 31/3/5", e.getMessage());

    }

}