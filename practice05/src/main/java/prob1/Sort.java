package prob1;

public class Sort {
	
	public static void main(String[] arg) {
	
		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int temp = 0;
		int count =  array.length;
		
		System.out.println( "Before sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print( array[ i ] + " " );
		}
		
		while(true)
		{
			int turn = 0;
			for(int i = 0; i < count-1; i++)
			{
				if(array[i+1] > array[i])
				{
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					
					turn = 1;
				}
			}
			
			if(turn != 1)
				break;		
		}
		
		System.out.println( "\nAfter Sort." );
		
		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}		

	}
}