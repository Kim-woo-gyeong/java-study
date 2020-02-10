package Chaper4;
//동일성이랑 동질성 비교
public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		
		//== : 동일성비교
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);
		
		//equals() : 동질성 비교 Object의 기본 구현은 동일성 비교와 같음.
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
	}

}
