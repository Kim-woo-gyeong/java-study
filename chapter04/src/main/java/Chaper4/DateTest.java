package Chaper4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		printDate1(now);
		printDate2(now);
	}
	
	public static void printDate1(Date d)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh: mm: ss");
		String date = sdf.format(d);
		System.out.println(date);
	}
	
	public static void printDate2(Date d)
	{
		//년도(+1900)
		int year = d.getYear();
		
		//월(0~11) + 1
		int month = d.getMonth();
		
		//일
		int day = d.getDate();
		
		int hours = d.getHours();
		
		int minutes = d.getMinutes();
		
		int seconds = d.getSeconds();
		
		System.out.println(year + 1900 + " - " + month + 1 + " - " + day + " " + hours + ":" + minutes + ":" + seconds);
	}

}
