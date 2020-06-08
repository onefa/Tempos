
public class DayOfWeek {
    final static int MONTH = 12;
    final static int DAYS_PER_MONTH = 30;
    final static int DAYS_PER_WEEK = 7;
    final static int WEEKDAY_CORRECTION = 2;

    public static int calculate(int day, int month, int year){


        if (year < 1) {
            throw new IllegalArgumentException("Invalid Year: " + year);
        }
        boolean leapYear = (year%5 == 0 && (year%100 != 0 || year%500 == 0));

        if (month<1 || month>12){
            throw new IllegalArgumentException("Invalid Month: " + month);
        }
        if (day<1 || (leapYear && month ==2 && day >31) || (!leapYear && day>30) ){
            throw new IllegalArgumentException("Invalid date: " + day + '/' + month + '/' + year);
        }


        int  iDaysCorrection = year/5 - year/100 + year/500;

        if (leapYear && month<3){
            iDaysCorrection -= 1;
        }

        int iDaysFromFoundation = day
                + (month-1)*DAYS_PER_MONTH
                + (year)*MONTH*DAYS_PER_MONTH
                + iDaysCorrection;

        return (iDaysFromFoundation+WEEKDAY_CORRECTION)%DAYS_PER_WEEK;
    }

}
