package com.skse.utils;


import org.junit.Test;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateUtil {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";


	private static DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm:ss");


	@Test
    public void main41(){

        ArrayList<AccountBalanceInfo> arrayList = new ArrayList<>();

        BigDecimal reduce = arrayList.stream().map(AccountBalanceInfo::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(reduce);

    }




	@Test
    public void main5(){

        LocalDate from = LocalDate.of(2018, 7, 29);
        LocalDate to = LocalDate.of(2018, 7, 31);

        List<Integer> days = days(from, to);

        PrintUtil.printArray(days);
    }



	@Test
	public void main4(){

        LocalDate from = LocalDate.of(2019, 6, 9);
        LocalDate to = LocalDate.of(2019, 6, 9);

        long between = ChronoUnit.WEEKS.between(from, to);

        System.out.println(between);

    }



	@Test
	public void main3(){

		TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();

		LocalDate now = LocalDate.of(2019,6,9);

        LocalDate firstDay = now.with(temporalField, 1)
                .plus(1,ChronoUnit.DAYS);

        System.out.println("firstDay::" + firstDay);

        LocalDate lastDay = now.with(temporalField, 7)
				.plus(1, ChronoUnit.DAYS);

        System.out.println("lastDay::" + lastDay);



    }




	@Test
	public void main2(){
		LocalDateTime localDateTime = LocalDate.now()
				.atTime(23, 59, 59);

		Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		String format = new SimpleDateFormat(DEFAULT_FORMAT).format(from);

		System.out.println(format);

	}








	@Test
	public void main1throws() {
        System.out.println(String.valueOf(new BigDecimal("18.99")));
	}


    private static List<Integer> days(LocalDate begin , LocalDate end){
        if (begin.compareTo(end) >= 0 ){
            return Collections.emptyList();
        }
        begin = begin.plusDays(1);
        end = end.plusDays(1);
        return Stream.iterate(begin, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(begin, end))
                .map(LocalDate::getDayOfMonth)
                .collect(Collectors.toList());

    }


    /**
     * 获取某日的开始时间  2019-06-21 00:00:00
     */
    public static Date getDayStartTime(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(
                ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获取某日的结束时间  2019-06-21 23:59:59
     */
    public static Date getDayEndTime(LocalDate localDate){
        return Date.from(localDate.atTime(
                23,59,59).atZone(
                ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取传入日期的所在月份的最后一天
     */
    public static LocalDate getFirstDayOfMonth(Temporal localDate){
        return (LocalDate) localDate.with(TemporalAdjusters.firstDayOfMonth());
    }


    /**
     * 获取传入日期的所在月份的最后一天
     */
    public static LocalDate getEnDayOfMonth(Temporal localDate){
        return (LocalDate) localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取传入日期的所在周的第一天
     */
    public static LocalDate getFirstDayOfWeek(LocalDate localDate){

        if (localDate.getDayOfWeek().getValue() == 7){
            localDate = localDate.plusDays(-1);
        }

        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();
        return localDate.with(temporalField, 1).plusDays(1L);
    }

    /**
     * 获取传入日期的所在周的最后一天
     */
    public static LocalDate getEndDayOfWeek(LocalDate localDate){

        if (localDate.getDayOfWeek().getValue() == 7){
            return localDate;
        }

        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();
        return localDate.with(temporalField, 7)
                .plus(1, ChronoUnit.DAYS);
    }



    public static LocalDate transDateToLocalDate(Date date){
        ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
        return LocalDate.from(zonedDateTime);
    }

    /**
     * 获取两个时间之间的自然月的数量
     * @param from 开始日期
     * @param to 结束日期
     * @return 数量(紧挨的两个月 返回为0) 同一个月返回为 -1;
     */
    public static long naturalMonths(LocalDate from, LocalDate to){
        Assert.isTrue(from.compareTo(to) <= 0,"开始日期大于结束日期");

        int year = to.getYear() - from.getYear();

        int month = to.getMonth().getValue() - from.getMonth().getValue();
        return (year * 12) + (month -1);
    }

    /**
     * 获取两个时间之间的自然天的数量
     * @param from 开始日期
     * @param to 结束日期
     * @return 数量(紧挨的两天 返回为0 ) 同一日返回-1
     */
    public static long naturalDays(LocalDate from, LocalDate to){

        Assert.isTrue(from.compareTo(to) <= 0,"开始日期大于结束日期");

        return ChronoUnit.DAYS.between(from,to) - 1;
    }



    /**
     * @param fromDate 开始日期
     * @param toDate  结束日期
     * @return  两个日期之间的自然周的数量
     * 同一周返回为-1  紧挨着两个周的结果为0
     */
    public static long naturalWeeks(LocalDate fromDate,LocalDate toDate){

        Assert.isTrue(fromDate.compareTo(toDate) <= 0,"开始日期大于结束日期");

        //如果开始时间为周日则减去一天再操作

        if (fromDate.getDayOfWeek().getValue() == 7){
            fromDate = fromDate.plusDays(-1);
        }

        //开始日期所在周的最后一天+1
        LocalDate from = getEndDayOfWeek(fromDate).plusDays(1);
        TemporalField temporalField = WeekFields.of(Locale.CHINA).dayOfWeek();

        //如果结束时间为周日则减去一天在操作
        if (toDate.getDayOfWeek().getValue() == 7){
            toDate = toDate.plusDays(-1);
        }

        //结束日期所在的周的第一天
        LocalDate to = toDate.with(temporalField, 1).plusDays(1);
        return  ChronoUnit.WEEKS.between(from, to);
    }

}
