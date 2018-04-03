package com.yimew.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
    /**
     * 日期对象转换为时间戳
     */
    public static long Date2Stamp(Date date) {
        long times = date.getTime();
        return times;
    }

    /**
     * 时间戳转换为日期对象
     */
    public static Date Stamp2Date(long times) {
        Date date = new Date(times);
        return date;
    }

    /**
     * 返回当前时间月份
     *
     * @return
     */
    public static Integer getMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }


    /**
     * 增加时间
     *
     * @return
     */
    public static Date addMin(Date date, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 本地时间转utc时间
     *
     * @param date
     * @return
     */
    public static Date local2Utc(Date date) {
        // 1、取得本地时间：
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 2、取得时间偏移量：
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);

        // 3、取得夏令时差：
        int dstOffset = cal.get(Calendar.DST_OFFSET);

        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        // 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
        return new Date(cal.getTimeInMillis());
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @return date
     */
    public static Date strToDateWithSec(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToDateWithMin(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToDateWithDay(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date strToDateWithDayDoubleYear(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 增加日期的天数
     *
     * @param days
     * @return
     */
    public static Date addDays(Date date, Integer days) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        // rightNow.add(Calendar.YEAR,-1);//日期减1年
        // rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR, days);// 日期加10天
        date = rightNow.getTime();
        return date;
    }

    /**
     * 日期转换成字符串
     *
     * @param date
     * @return str
     */
    public static String DateToStrWithMin(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String str = format.format(date);
        return str;
    }

    public static String DateToStrWithSec(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    public static String DateToStrWithDay(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }

    public static String DateToStrWithDayDoubleYearWithout_(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String str = format.format(date);
        return str;
    }

    /**
     * 根据utc时间和时区改为时区所在时间
     **/
    public static Date utc2local(Date utcdate, String timeZone) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(utcdate);

        StringBuffer sbTimeZone = new StringBuffer(timeZone);
        timeZone = sbTimeZone.insert(3, ":").toString();
        TimeZone timeZone2 = TimeZone.getTimeZone("GMT" + timeZone);
        // 标准时间偏移量
        int zoneOffset = timeZone2.getRawOffset();
        // 夏令时值
        int dstOffset = timeZone2.getDSTSavings();
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(Calendar.MILLISECOND, +(zoneOffset + dstOffset));

        // 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
        return new Date(cal.getTimeInMillis());
    }

    public static void main(String[] args) {
        Date date = utc2local(new Date(), "+0800");
        System.out.println(date);
    }

    /**
     * 获取date在一天中的开始时间
     * @param date
     * @return
     */
    public static Date getBeginOfDay(Date date) {
        // 获取当天凌晨0点0分0秒Date
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
        Date beginOfDate = calendar1.getTime();
        return beginOfDate;
    }

    public static Date getEndOfDay(Date date) {
        // 获取当天23点59分59秒Date
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar2.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        Date endOfDate = calendar2.getTime();
       return endOfDate;
    }


    public static Date getMondayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.DAY_OF_WEEK, calendar.MONDAY);
        return calendar.getTime();
    }

    public static Date getSundayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.DAY_OF_WEEK, calendar.MONDAY);
        return addDays(calendar.getTime(),6);
    }
}
