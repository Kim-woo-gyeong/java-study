package Exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("some codes0");
		
		try {
			System.out.println("some codes1");
			int result = (1 + 2 + 3)/b;
			System.out.println("some codes2");
			
		}catch(ArithmeticException ex){
			
			//1. 사과..
			System.out.println("죄송합니다.");
			
			//2. 로그로 남김(파일, DB)
			System.out.println(ex);
			
			//3. 정상종료
			return;
			
			}finally {
				System.out.println("some codes4");
			}
	
		System.out.println("some codes5");
	}

}
