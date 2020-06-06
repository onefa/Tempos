public class DayOfWeek {
    final static int I_MONTH = 12;
    final static int I_DAYS_PER_MONTH = 30;
    final static int I_DAYS_PER_WEEK = 7;

    public static int calculate(int iDay, int iMonth, int iYear){

        int  iDaysCorrection = iYear/5 - iYear/100 + iYear/500;

        if (iYear%5 == 0 && (iYear%100 != 0 || iYear%500 == 0) && iMonth>2){
            iDaysCorrection += 1;
        }

        int iDaysFromFoundation = iDay
                + iMonth*I_DAYS_PER_MONTH
                + iYear*I_MONTH*I_DAYS_PER_MONTH
                + iDaysCorrection;

        return (iDaysFromFoundation)%I_DAYS_PER_WEEK;

    }

}
