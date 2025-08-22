package com.gientech.mpbcz.utils;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 *     类功能：
 * </pre>
 * Author: lifei
 * Date: 2023/3/11 10:48
 */
public class DateUtils {
    public static LocalDateTime parse(String dateStr) {
        return LocalDateTime.parse(dateStr);
    }

    public static Date  nextYearDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); //设置起时间
        cal.add(Calendar.YEAR, 1); //增加一年
        return cal.getTime();
    }

    public static String  dateToString(Date date){
        String format = null;
        if (null != date){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            format = sdf.format(date);
        }
        return format;
    }

    public static String dateFormat(Date date) {
        String format = null;
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            format = sdf.format(date);
        }
        return format;
    }

    public static String dateToLineString(Date date) {
        String format = null;
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            format = sdf.format(date);
        }
        return format;
    }
    public static Date stringToDate(String str){
        Date  date=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(str)) {
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                return null;
            }
        }
        return date;
    }

    public static Date stringToyyyyMMdd(String str){
        Date  date=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (StringUtils.isNotEmpty(str)) {
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                return null;
            }
        }
        return date;
    }

    public static Date stringToDateAutoPattern(String str, String pattern) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (StringUtils.isNotEmpty(str)) {
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                return null;
            }
        }
        return date;
    }

    public static String dateFormatAutoPattern(Date date, String pattern) {
        String format = null;
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            format = sdf.format(date);
        }
        return format;
    }

    /**
     * 获取30天前日期
     */

    public static Date getThrityDay() {

        Date now = new Date();
        Date startDate = org.apache.commons.lang3.time.DateUtils.addDays(now, 30);
        return startDate;
    }
    public static Date now() {
        return new Date();
    }

    public static Date yesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(5, -1);
        return cal.getTime();
    }

    public static Date tomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(5, 1);
        return cal.getTime();
    }

    public static String getDateToStr(Date date,String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        return dateformat.format(date);
    }
    public static String getFormatTimeStr(LocalDateTime time, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        String localTime = df.format(time);
        return localTime;
    }
    @SneakyThrows
    public static Date getStrToDate(String dateStr, String format){
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        return dateformat.parse(dateStr);
    }

    public static String getTomrrowDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        Date tomrrow = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
        return dateformat.format(tomrrow);
    }

    public static Date getFormatDate(Date date,String format){
        String dateToStr = getDateToStr(date, format);
        Date strToDate = getStrToDate(dateToStr, format);
        return strToDate;
    }


    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * @param dateStr, timeStr, dateFormat
     * @return LocalDateTime
     * @description 根据指定的格式，将日期和时间字符串拼接转换为LocalDateTime类型
     * @author wuyf
     */
    public static LocalDateTime parseStrToDate(String dateStr, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDateTime.parse(dateStr, formatter);
    }
}