package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for( int i = 1; i <=100; i++ ) {
			String s = String.valueOf(i);
			int count = 0;
			int turn = 1;
			for(int j = 0; j < s.length();j++)
			{
				if(s.charAt(j)=='3' || s.charAt(j)=='6' || s.charAt(j) == '9')
				{
					turn = 0;
					count++;
				}
			}
			if(turn == 0 && count==2)
				System.out.println(s + " 짝짝");
			
			else if(turn==0 && count != 0)
				System.out.println(s + " 짝");
			
		}
	}
}
