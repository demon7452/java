package com.charpter4.objectAndClass;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {

	public static void main(String[] args) {
//		printAllDaysOfOneMonth(new GregorianCalendar());
//		printAllDaysOfOneMonth(new GregorianCalendar(2016,Calendar.JUNE,22));
//		GregorianCalendar calendar1 = new GregorianCalendar();
		GregorianCalendar calendar2 = new GregorianCalendar(2016,Calendar.JUNE,22);
//		System.out.println(calendar1.get(Calendar.DAY_OF_MONTH) +"  " + calendar1.get(Calendar.MONTH));
//		System.out.println(calendar2.get(Calendar.DAY_OF_MONTH) +"  " + calendar2.get(Calendar.MONTH));
//		printAllDaysOfOneMonth(calendar1);
		printAllDaysOfOneMonth(calendar2);
		printAllDaysOfOneMonth(new GregorianCalendar(2016,Calendar.JULY,11));
	}
	
	public static void printAllDaysOfOneMonth(GregorianCalendar calendar){
		int today = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		
		//set calendar to start date of the month;日期设为当月的第一天
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);//当月第一天是周几
		int firstDayOfWeek = calendar.getFirstDayOfWeek();
		
		int intent = weekDay -1;
//		while (weekDay != firstDayOfWeek) {
//			intent++;
//			//获得当天的前一天是周几
//			calendar.set(Calendar.DAY_OF_MONTH, -1);
//			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
//		}
		
		String[] weekNames = new DateFormatSymbols().getShortWeekdays();
		for(String weekName:weekNames)
			System.out.printf("%6s",weekName);
//		do{
//			System.out.printf("%4s",weekNames[firstDayOfWeek]);
//			calendar.add(Calendar.DAY_OF_MONTH, 1);
//			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
//		}while(weekDay != firstDayOfWeek);
		System.out.println();
		
		for(int i=1;i<= intent;i++)
			System.out.printf("%6s", "");
		
		calendar.set(Calendar.DAY_OF_MONTH, 1);//重新将日期设为当月的第一天
		int nextMonth = 0;
		do{
			month = calendar.get(Calendar.MONTH);
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%5s", day);
			if(today == day)
				System.out.print("*");
			else
				System.out.print(" ");
			calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
			weekDay = calendar.get(Calendar.DAY_OF_WEEK);
			if(weekDay == firstDayOfWeek)
				System.out.println();
			nextMonth = calendar.get(Calendar.MONTH);
		}while (month == nextMonth);
		System.out.println();
	}
}
