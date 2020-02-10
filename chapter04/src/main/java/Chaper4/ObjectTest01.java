package Chaper4;

public class ObjectTest01 {

	public static void main(String[] args) {
		
		Point p = new Point(10, 20);
		
		//Class klass = p.getClass(); 
		
		System.out.println(p.getClass()); //reflection 내가 생성됐던 클래스 정보를..? 프레임워크에서 많이 사용
		System.out.println(p.hashCode());    // reference value X, address X -> 객체가 생긴 주소 기반의 해싱값(int)
		System.out.println(p); // println은 toString 호출하여 출력,
		System.out.println(p.toString()); //getClass() + "@" + hashcode()
		
	}

}
