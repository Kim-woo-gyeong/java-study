package Chapter3;

public class Student extends Person {
	public Student()
	{
		// 자식 생성자에서 부모 생성자를 명시적으로 호출 (= super()) 하지 않으면 자동으로 부모 기본 생성자를 호출.
		//super(); -> 이것이 생략되어 있음.
		System.out.println("Student() Called");
	}
}
