package Chapter3;

public class SwapTest03 {

	public static void main(String[] args) {
		
		value a = new value();
		a.val = 10;
		
		value b = new value();
		b.val = 20;
		
		System.out.println(a.val + ":" + b.val);
		swap(a,b);
		System.out.println(a.val + ":" + b.val);

	}
	
	public static void swap(value m, value n)
	{
		int temp = m.val;
		m.val = n.val;
		n.val = temp;
	}

}
