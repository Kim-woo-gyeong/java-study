package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		for(int i = 0; i < 3; i++)
		{
			goods[i] = new Goods();
		}
		
		for(int i = 0; i < 3; i++)
		{
			String s = scanner.nextLine();
			goods[i].setGoods(s);
		}
		
		for(int i = 0; i < 3; i++)
		{
			goods[i].getGoods();
		}
		scanner.close();
	}
}
