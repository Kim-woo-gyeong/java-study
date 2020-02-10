package Thread;

public class UpperCaseAlphabet {
	//Thread를 상속 받을 수 없는 경우..?
	public void print() {
		for(char c = 'A'; c <='Z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
