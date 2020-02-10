package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double hap = 0;
		System.out.println("5개의 숫자를 입력하세요.");
		for(int i = 0; i < 5; i++)
		{
			intArray[i] = scanner.nextInt();
			hap+=intArray[i];
		}
		
		System.out.println("평균은 " + hap/5 + "입니다.");
		scanner.close();
	}

}
