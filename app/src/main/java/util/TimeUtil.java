package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/11/12.
 */

public class TimeUtil {
    /**
     *     时间戳转换成日期格式字符串
     *     @param seconds 精确到秒的字符串
     *     @param format
     *     @return
     */
    public static String getDateToString(String seconds, String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }

    public static String getDateToString4now(String format) {
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    //将字符串转为时间戳
    public static long getStringToDate(String dateString, String format) {
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format,Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Date date = new Date();
        try{
            date = dateFormat.parse(dateString);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return date.getTime();
    }


    /**
     * 输入时间戳变星期
     */
    public static String getWeek(long timeStamp) {
        int mydate = 0;
        String week = null;
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cd =  Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        cd.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        cd.setTime(new Date(timeStamp));
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        // 获取指定日期转换成星期几
        if (mydate == 1) {
            week = "周日";
        } else if (mydate == 2) {
            week = "周一";
        } else if (mydate == 3) {
            week = "周二";
        } else if (mydate == 4) {
            week = "周三";
        } else if (mydate == 5) {
            week = "周四";
        } else if (mydate == 6) {
            week = "周五";
        } else if (mydate == 7) {
            week = "周六";
        }
        return week;
    }

    /**
     * 输入时间戳变星期
     */
    public static String getWeek4now() {
        int mydate = 0;
        String week = null;
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        Calendar cd =  Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        cd.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        cd.setTime(cd.getTime());
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        // 获取指定日期转换成星期几
        if (mydate == 1) {
            week = "周日";
        } else if (mydate == 2) {
            week = "周一";
        } else if (mydate == 3) {
            week = "周二";
        } else if (mydate == 4) {
            week = "周三";
        } else if (mydate == 5) {
            week = "周四";
        } else if (mydate == 6) {
            week = "周五";
        } else if (mydate == 7) {
            week = "周六";
        }
        return week;
    }

}
