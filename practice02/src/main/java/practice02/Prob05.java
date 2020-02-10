package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int k = r.nextInt(100)+1;
		int max = 100, min = 1;
		int i = 2;
		String answer;
		System.out.println("수를 결정하였습니다. 맞추어 보세요");
		System.out.println(min + "-" + max);
		System.out.print("1>>");
		int user = scanner.nextInt();
		
		while(true)
		{
			if(k > user)
			{
				System.out.println("더 높게");
				System.out.println(user + "-" + max);
				min = user;
			}
			else if(k < user)
			{
				System.out.println("더 낮게");
				System.out.println(min + "-" + user);
				max = user;
			}
			else if(k==user)
			{
				System.out.println("맞췄습니다.");
				System.out.print("다시 하시겠습니까?(y/n)>>");
				answer = scanner.next();
				if(answer.equals("y"))
					break;
			}
			System.out.print(i+">>");
			user = scanner.nextInt();
			i+=1;
		}
		scanner.close();

	}
}
