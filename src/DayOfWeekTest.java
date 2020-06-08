import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

class DayOfWeekTest {

    @org.junit.jupiter.api.Test
    void calculate() {
        /*

        class testCaseDate {
            int day;
            int month;
            int year;
        }

        ArrayList<testCaseDate>

                */
        int calcFoundation = DayOfWeek.calculate(24,8,1);
        int calcAnniversary = DayOfWeek.calculate(24,8,1001);
        int checkDayOfWeek = 1;
        Assertions.assertEquals(checkDayOfWeek,calcAnniversary);
        Assertions.assertEquals(checkDayOfWeek,calcFoundation);

        try {
            System.out.println("Invalid year handling:");
            checkDayOfWeek = DayOfWeek.calculate(15,1,0);
        }catch (IllegalArgumentException e){
            System.out.println("Get exception: " + e.getMessage());
        }

        try {
            System.out.println("Invalid month handling:");
            checkDayOfWeek = DayOfWeek.calculate(15,13,123);
        }catch (IllegalArgumentException e){
            System.out.println("Get exception: " + e.getMessage());
        }

        try {
            System.out.println("Invalid 31 feb handling:");
            checkDayOfWeek = DayOfWeek.calculate(31,2,4);
        }catch (IllegalArgumentException e){
            System.out.println("Get exception: " + e.getMessage());
        }

    }
}