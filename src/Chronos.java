/*
Я не знал в каком виде тебе написать решение этой задачки,
подумал пусть будет так.
Не ругайся, что я не проверяю ни формат, ни валидность даты,
а просто наличие аргумента на входе.
В конце концов задача была вроде не в этом?
Теперь про саму задачку.
Если я правильно понял, день основания колонии 24.08.1 года
по календарю Хроноса и это был вторник.
Писал чуть дольше чем думал:)
Вроде проверил.
 */

public class Chronos {
    public static void main(String[] args){
        String[] sWeekDays = {"Mo","Tu","We","Th","Fr","Sa","Su"};
        int iDay, iMonth, iYear;
        int iDaysFromFoundation, iDaysCorrection;
        int sWeekDay;
        final int I_MONTH = 12;
        final int I_DAYS_PER_MONTH = 30;

        if (args.length!=1){
            System.out.println("Error in parameters. Use DD/MM/YYYY");
            System.exit(0);
        }
        String[] dateValues = args[0].split("/");
        iDay = Integer.parseInt(dateValues[0]);     // current day
        iMonth = Integer.parseInt(dateValues[1]);   // current month
        iYear = Integer.parseInt(dateValues[2]);    // current year

        /*----- solution -----*/
        iDaysCorrection = iYear/5 - iYear/100 + iYear/500;

        if (iYear%5 == 0 && (iYear%100 != 0 || iYear%500 == 0) && iMonth>2){
            iDaysCorrection += 1;
        }

        iDaysFromFoundation = iDay
                            + iMonth*I_DAYS_PER_MONTH
                            + iYear*I_MONTH*I_DAYS_PER_MONTH
                            + iDaysCorrection;
        sWeekDay = (iDaysFromFoundation)%sWeekDays.length;
        System.out.println(sWeekDays[sWeekDay]);

    }
}
