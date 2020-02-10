package Exception;

import java.io.IOException;

public class Myclass {

	public void danger() throws IOException,  MyException//예외처리를 할 수 있다는 것을 표시
	{
		System.out.println("some codes1");
		System.out.println("some codes1");
		
		if(5 - 5 == 0)
		{
			throw new MyException();
		}
		if(10 - 2 == 8)
		{
			throw new IOException();
		}
		System.out.println("some codes3");
		System.out.println("some codes4");
	}
}
