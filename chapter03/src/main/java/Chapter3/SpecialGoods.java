package Chapter3;

import mypackage.Goods;

public class SpecialGoods extends Goods {
	public void test() {
		//protected는 패키지 상관 없이 자식에서는 가능
		System.out.println(price);
	}
}
