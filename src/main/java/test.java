import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class test {

    public static void main(String[] args) throws Exception {

        String dateTimeFrom = "2022-01-06 22:00:00";
        String dateTimeNow = "2022-01-06 21:00:00";

//        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date date1 = null;
//        Date date2 = null;
//        try {
//            date1 = sdf.parse(dateTimeFrom);
//            date2 = sdf.parse(dateTimeNow);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        long diff = date2.getTime() - date1.getTime();
//
//        System.out.println(TimeUnit.MILLISECONDS.toMinutes(diff));


        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = sdf.parse(dateTimeNow);
        Date date2 = sdf.parse(dateTimeFrom);

        System.out.println( Math.abs(date1.getTime() - date2.getTime()) > MILLIS_PER_DAY );



    }
}
