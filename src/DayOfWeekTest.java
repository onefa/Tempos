import org.junit.jupiter.api.Assertions;

class DayOfWeekTest {

    @org.junit.jupiter.api.Test
    void calculate() {
        int calcFoundation = DayOfWeek.calculate(24,8,1);
        int calcAnniversary = DayOfWeek.calculate(24,8,1001);
        int checkDayOfWeek = 1;
        Assertions.assertEquals(checkDayOfWeek,calcAnniversary);
        Assertions.assertEquals(checkDayOfWeek,calcFoundation);
    }
}