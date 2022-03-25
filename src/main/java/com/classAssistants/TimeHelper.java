package com.classAssistants;

import jdk.jfr.Description;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeHelper {



    @Description("Format of date is  yyyy-MM-dd hh:mm:ss")
    public static long monthAgoFrom(String dateTimeFrom) throws ParseException{

        String dateTimeNow = getCurrentDateTime();
        String dateNow = getCurrentDateTime();
         long monthsBetween = ChronoUnit.MONTHS.between(
                LocalDate.parse("2022-01-24").withDayOfMonth(1),
                LocalDate.parse(dateNow).withDayOfMonth(1));
         return monthsBetween;

    }

    public static String getCurrentDateTime(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        return   dtf.format(now);

    }

}
