import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.IllegalArgumentException;

import static org.junit.jupiter.api.Assertions.assertThrows;


class DayOfWeekTest {
    class CheckParameter {
        int day;
        int month;
        int year;
        int dayOfWeek;
        String exceptMessage;

        public CheckParameter(int day, int month, int year, String exceptMessage) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.exceptMessage = exceptMessage;
        }

        public CheckParameter(int day, int month, int year, int dayOfWeek) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dayOfWeek = dayOfWeek;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }

        public String getExceptMessage() {
            return exceptMessage;
        }
    }
    CheckParameter [] acceptParameters = { new CheckParameter(24,8,1,1),
                                           new CheckParameter(24,8,1001,1),
                                           new CheckParameter(1,1,1,6),
                                           new CheckParameter(30,1,1,0),
                                           new CheckParameter(1,3,5,2),
                                           new CheckParameter(30,3,5,3),
                                           new CheckParameter(31,2,5,1)
    };

    CheckParameter [] exceptParameters = { new CheckParameter(15,11,0,"Invalid Year: 0"),
                                           new CheckParameter(1,13,10,"Invalid Month: 13"),
                                           new CheckParameter(31,2,1,"Invalid Date: 31/2/1"),
                                           new CheckParameter(31,3,5,"Invalid Date: 31/3/5"),

    };

    @Test
    void calculateAccept() {
        for (CheckParameter acceptParameter : acceptParameters) {
            Assertions.assertEquals(acceptParameter.getDayOfWeek(),
                                    DayOfWeek.calculate(acceptParameter.getDay(),
                                                        acceptParameter.getMonth(),
                                                        acceptParameter.getYear()));
        }
    }

    @Test
    void calculateExcept() throws IllegalArgumentException{
        for (CheckParameter exceptParameter : exceptParameters) {
            Throwable e = assertThrows(IllegalArgumentException.class,
                                      () -> DayOfWeek.calculate(exceptParameter.getDay(),
                                                                exceptParameter.getMonth(),
                                                                exceptParameter.getYear()));
            Assertions.assertEquals(exceptParameter.getExceptMessage(), e.getMessage());
        }
    }

}