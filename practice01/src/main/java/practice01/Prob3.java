package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("숫자를 입력하세요 : ");
			int number = scanner.nextInt();
			int hap = 0;
			if(number%2==0)
			{
				for(int i = 0;i<=number;i+=2)
				{
					hap+=i;
				}
			}
			else
			{
				for(int i = 1;i<=number;i+=2)
				{
					hap+=i;
				}
			}
			System.out.println("결과값 : " + hap);
		}
	}
}
