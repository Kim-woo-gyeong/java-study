package Exception;

import java.io.IOException;

public class MyclassTest {

	public static void main(String[] args) {
		
		Myclass myclass = new Myclass();
		try {
			myclass.danger();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
