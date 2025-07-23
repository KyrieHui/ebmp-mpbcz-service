package com.gientech.mpbcz.utils;

import com.dap.flow.common.exception.BusinessException;
import com.gientech.errorenum.ErrorCodeEnum;
import com.google.common.collect.Lists;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author wuyf
 * @description 预约时间处理工具类
 * @date 2022/6/1-9:50
 */
public class PrecnTimeUtils {

    /**
     * @param dateStr, timeStr, dateFormat
     * @return LocalDateTime
     * @description 根据指定的格式，将日期和时间字符串拼接转换为LocalDateTime类型
     * @author wuyf
     */
    public static LocalDateTime parseStrToDate(String dateStr, String timeStr, String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return LocalDateTime.parse(dateStr + timeStr, formatter);
    }

    public static String formatDateToStr(LocalDateTime dateTime, String formatDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
        return formatter.format(dateTime);
    }

    /**
     * @param precnStartTm, monthDay, precnEndTm
     * @return void
     * @description 计算按月预约预约的执行时间列表
     * @author wuyf
     */
    public static void calMonthExecuteTm(LocalDateTime precnStartTm, String monthDay, LocalDateTime precnEndTm, List<LocalDateTime> resultList) {
        Integer targetDay = Integer.parseInt(monthDay);
        if (targetDay > 28 || targetDay < 1) {
            throw new BusinessException(ErrorCodeEnum.MPBCZ0000023, "每月几号");
        }
        LocalDateTime tmpDateTime = precnStartTm;
        // 根据每月几号校正首次预约执行时间
        int difference = targetDay - tmpDateTime.getDayOfMonth();
        if (difference > 0) {
            tmpDateTime = tmpDateTime.plusDays(difference);
        } else if (difference < 0) {
            tmpDateTime = tmpDateTime.plusMonths(1).plusDays(difference);
        }
        while (!tmpDateTime.isAfter(precnEndTm)) {
            resultList.add(tmpDateTime);
            tmpDateTime = tmpDateTime.plusMonths(1);
        }
    }

    /**
     * @param precnStartTm, weekDay, precnEndTm, resultList
     * @return List<LocalDateTime>
     * @description 计算按周预约预约的执行时间列表
     * @author wuyf
     */
    public static void calWeekExecuteTm(LocalDateTime precnStartTm, String weekDay, LocalDateTime precnEndTm, List<LocalDateTime> resultList) {
        if (Integer.parseInt(weekDay) > 7 || Integer.parseInt(weekDay) < 1) {
            throw new BusinessException(ErrorCodeEnum.MPBCZ0000001, "每周周几");
        }
        LocalDateTime tmpDateTime = precnStartTm;
        DayOfWeek targetDay = DayOfWeek.of(Integer.parseInt(weekDay));
        // 根据每周周几校正首次预约执行时间
        int difference = targetDay.getValue() - tmpDateTime.getDayOfWeek().getValue();
        if (difference > 0) {
            tmpDateTime = tmpDateTime.plusDays(difference);
        } else if (difference < 0) {
            tmpDateTime = tmpDateTime.plusDays(difference).plusWeeks(1);
        }
        while (!tmpDateTime.isAfter(precnEndTm)) {
            resultList.add(tmpDateTime);
            tmpDateTime = tmpDateTime.plusWeeks(1);
        }
    }

    /**
     * @param precnStartTm, precnEndTm, resultList
     * @return void
     * @description 计算预约每日转账的执行时间列表
     * @author wuyf
     */
    public static void calDayExecuteTm(LocalDateTime precnStartTm, LocalDateTime precnEndTm, List<LocalDateTime> resultList) {
        LocalDateTime tmpDateTime = precnStartTm;
        // 根据每月几号校正首次预约执行时间
        while (!tmpDateTime.isAfter(precnEndTm)) {
            resultList.add(tmpDateTime);
            tmpDateTime = tmpDateTime.plusDays(1);
        }
    }


    public static final String getWeekZhCN(Date date){
        String weekDay = "";
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        weekDay = weekDays[w];

        return weekDay;
    }
    /**
     * @description 校验预约时间, 并返回预约执行时间清单
     * @author yfw
     */
    public static List<LocalDateTime> getPrecnTimes(String rmndFrqcy, String  monthDay,String weekDay,
                                                    String specDay,String prepMagTm) {
        List<LocalDateTime> resultList = Lists.newArrayList();
        //预约频率 01-仅一次 02-每日一次 03-每周一次 04-每月一次
        // 判断是否为单次预约
        if (rmndFrqcy.equals("01")) {
            // 单次预约
            resultList.add(DateUtils.parseStrToDate(specDay+prepMagTm,"yyyyMMddHHmm"));
            return resultList;
        }

        LocalDateTime precnStartTm = LocalDateTime.now();
        LocalDateTime precnEndTm = precnStartTm.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        // 校验预约日期范围内，是否有满足执行条件的日期
        String precnFrqcy = Optional.of(rmndFrqcy).get();
        if (precnFrqcy.equals("02")) {
            // 预约频率为每日执行
            PrecnTimeUtils.calDayExecuteTm(precnStartTm, precnEndTm, resultList);
        } else if (precnFrqcy.equals("03")) {
            // 预约频率为每周一次
            try {
                PrecnTimeUtils.calWeekExecuteTm(precnStartTm, weekDay, precnEndTm, resultList);
            } catch (Exception e) {
                throw new BusinessException(ErrorCodeEnum.MPBCZ0000001, "每周几号");
            }
        } else if (precnFrqcy.equals("04")) {
            // 预约频率为每月一次
            try {
                PrecnTimeUtils.calMonthExecuteTm(precnStartTm, monthDay, precnEndTm, resultList);
            } catch (Exception e) {
                throw new BusinessException(ErrorCodeEnum.MPBCZ0000001, "每月几号");
            }
        }
        return resultList;
    }


    /**
     * @description 校验预约时间, 并返回预约执行时间清单
     * @author yfw
     */
    public static List<LocalDateTime> getPrecnTimes(String prepMagTm,String rmndFrqcy) {
        //01-仅一次 02-每日一次 03-每周一次 04-每月一次
        LocalDateTime precnStartTm = DateUtils.parseStrToDate(prepMagTm.substring(0,8)+"00","yyyyMMddHH");
        LocalDateTime precnEndTm = precnStartTm.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        List<LocalDateTime> resultList = Lists.newArrayList();
        // 判断是否为单次预约
        if (rmndFrqcy.equals("01")) {
            // 单次预约
            resultList.add(precnStartTm);
            return resultList;
        }
        // 校验预约日期范围内，是否有满足执行条件的日期
        String precnFrqcy = Optional.of(rmndFrqcy).get();
        if (precnFrqcy.equals("02")) {
            // 预约频率为每日执行
            PrecnTimeUtils.calDayExecuteTm(precnStartTm, precnEndTm, resultList);
        } else if (precnFrqcy.equals("03")) {
            // 预约频率为每周一次
            try {
                PrecnTimeUtils.calWeekExecuteTm(precnStartTm, PrecnTimeUtils.getWeekZhCN(new Date()), precnEndTm, resultList);
            } catch (Exception e) {
                throw new BusinessException(ErrorCodeEnum.MPBCZ0000001, "每周几号");
            }
        } else if (precnFrqcy.equals("04")) {
            // 预约频率为每月一次
            try {
                PrecnTimeUtils.calMonthExecuteTm(precnStartTm, prepMagTm.substring(6, 8), precnEndTm, resultList);
            } catch (Exception e) {
                throw new BusinessException(ErrorCodeEnum.MPBCZ0000001, "每月几号");
            }
        }
        return resultList;
    }

    public static void main(String[]args){
        System.out.println(getWeekZhCN(new Date()));
    }



}
