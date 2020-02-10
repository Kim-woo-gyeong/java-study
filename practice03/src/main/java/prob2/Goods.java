package prob2;

import java.util.Scanner;

public class Goods {
	
	private String str;
	Scanner scanner = new Scanner(System.in);
	
	public void setGoods(String s)
	{
		this.str = s;
	}
	
	public void getGoods()
	{
		String[] tokens = str.split(" ");
		System.out.println(tokens[0]+"(가격:"+tokens[1]+"원)이 " + tokens[2] + "개 입고되었습니다.");
	}
}
