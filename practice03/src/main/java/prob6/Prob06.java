package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if("quit".equals(expr))
				break;
			
			String[] tokens = expr.split(" ");
			if(tokens.length!=3)
			{
				System.out.println(">>계산할 수 없는 연산식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result = 0;
			
			if("+".equals(tokens[1]))
			{
				Add add = new Add();
				add.setValue(lValue, rValue);
				result = add.calculate();
			}
			
			System.out.println(">> " + result);
		}
		
		scanner.close();
		
	}
}
