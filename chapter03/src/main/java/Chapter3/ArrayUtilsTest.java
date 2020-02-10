package Chapter3;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		
		int[] a1 = {10,20,30,40,50};
		
		//double[] d1 = new ArrayUtils().intToDouble(a1);
		double[] d1 = ArrayUtils.intToDouble(a1);
		
		for(int i = 0; i < a1.length;i++)
			System.out.print(d1[i] + " ");
	}

}
