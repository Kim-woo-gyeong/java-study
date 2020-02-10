package Chaper4;

import java.util.Calendar;

public class CalenderTest {
	//public static final int MONTH = 1;//마지막으로 변수를 선언하겠다
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.DATE,23);
		
		printDate(cal);
		
		cal.set(2014, 11 , 29);
		cal.add(Calendar.DATE, 2000);
		printDate(cal);
	}
	
	public static void printDate(Calendar cal)
	{
		String[] days = {"일", "월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		//월(0~11)
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		//요일(1<일요일>~7)
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year + "년 " + (month+1) + "월 " + date + "일 " +days[day-1] +"요일 "+ hour + "시 " + minutes + "분 " + seconds + "초 ");
	}

}
