package Chaper4;

public class MyClassTest {

	public static void main(String[] args) {
		
		//new MyClass();
		
		MyClass myclass1 = MyClass.getInstance();
		MyClass myclass2 = MyClass.getInstance();
		MyClass myclass3 = MyClass.getInstance();
		
		System.out.println(myclass1 == myclass2);
		System.out.println(myclass2 == myclass3);
		
	}

}
