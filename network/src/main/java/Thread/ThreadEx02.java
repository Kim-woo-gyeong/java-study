package Thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		Thread thread01 = new DigitalThread();
		Thread thread02 = new Alphabet();
		Thread thread03 = new DigitalThread();
		
		thread01.start();
		thread02.start();
		thread03.start();
	}

}
