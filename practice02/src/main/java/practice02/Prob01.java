package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");
		int money = scanner.nextInt();
		int a;
		int i = 0;
		while(money>0) {
			a = money / MONEYS[i];
			money = money % MONEYS[i];
			System.out.println(MONEYS[i] + "원 : " + a + " 개");
			i+=1;
		}
		
		scanner.close();
	}

}
