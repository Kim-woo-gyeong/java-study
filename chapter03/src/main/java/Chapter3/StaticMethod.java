package Chapter3;

public class StaticMethod {
	int n;
	static int m;
	
	void f1()
	{
		System.out.println(n);
	}
	
	static void s1()
	{
		// static method에서 인스턴스 변수 접근 불가
		//System.out.println(n);
	}
	
	void f2()
	{
		//같은 클래스의 클래스변수(static 변수) 접근에서는 클래스 이름 생략 가능.
		System.out.println(StaticMethod.m);
	}
	
	static void s2()
	{
		System.out.println(m);
	}
	
	void f3()
	{
		f2();
	}
	
	void f4()
	{
		StaticMethod.s1();
	}
	
	static void s3()
	{
		//static method에서 인스턴스 메소드 접근은 불가능
		//f1();
	}
	
	static void s4()
	{
		StaticMethod.s2();
	}
}
