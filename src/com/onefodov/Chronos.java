package com.onefodov;
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

/* Отдельный класс создал и мне в таком виде он нравится больше всего
 * Теперь займусь юниттестами */


public class Chronos {
    public static void main(String[] args) {
        String[] sWeekDays = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
        int iDay, iMonth, iYear;

        if (args.length != 1) {
            System.out.println("Error in parameters. Use DD/MM/YYYY");
            System.exit(0);
        }
        String[] dateValues = args[0].split("/");
        iDay = Integer.parseInt(dateValues[0]);     // current day
        iMonth = Integer.parseInt(dateValues[1]);   // current month
        iYear = Integer.parseInt(dateValues[2]);    // current year

        System.out.println(sWeekDays[DayOfWeek.calculate(iDay, iMonth, iYear)]);
    }
}
