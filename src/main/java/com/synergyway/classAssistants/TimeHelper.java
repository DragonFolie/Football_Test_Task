package com.synergyway.classAssistants;

import jdk.jfr.Description;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeHelper {

    public static long timeConvertToMinute(String dateTimeTwo) {
        String dateTimeOne = "00:00:00";

        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(dateTimeOne);
            date2 = sdf.parse(dateTimeTwo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = date2.getTime() - date1.getTime();
        long result = TimeUnit.MILLISECONDS.toMinutes(diff);
        return result;


    }

    public static long findDifferentBetweenDateTime(String dateTimeOne,String dateTimeTwo) {


        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(dateTimeOne);
            date2 = sdf.parse(dateTimeTwo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.MILLISECONDS.toMinutes(diff);


    }

    @Description("Format of date is  yyyy-MM-dd hh:mm:ss")
    public static boolean isMoreThan24Hour(String dateTimeFrom,String dateTimeNow) throws ParseException{

        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = sdf.parse(dateTimeNow);
        Date date2 = sdf.parse(dateTimeFrom);

        return Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY;
    }

    public static String getCurrentDateTime(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return   dtf.format(now);

    }

}
