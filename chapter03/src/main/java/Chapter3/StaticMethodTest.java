package Chapter3;

public class StaticMethodTest {

	public static void main(String[] args) {
		int a = Math.abs(-20); //abs 는 static 메소드.
		int b = Math.max(10, 15);
		System.out.println(a + " " + b);
		
		System.out.println(StaticMethod.m);
	}

}
