package Chapter3;

import mypackage.Goods;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.name = "nikon";  
		//public은 접근제한 없음 
		
		//goods.countSold = 100; 
		//default는 같은 패키지에서만 접근 가능
		
		//goods.countStock = 50; 
		//private는 하나의 클래스 내부에서만 접근 가능
		
		//goods.price = 10000;   
		//protected는 같은 패키지 또는 자식에서 접근이 가능

		//System.out.println(goods.name + " " + goods.countSold + " " + goods.countStock + " " + goods.price);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countofgoods);
	}

}
