package Thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread01 = new DigitalThread();
		Thread thread02 = new Alphabet();
		//Thread thread03 = new UpperCaseAlphabetRunnableImpl();//부모가 쓰레드가 아니라서 불가능
		Thread thread03 = new Thread(new UpperCaseAlphabetRunnableImpl()); //run이 구현되어 있는 일반 클래스를 상속..?
		
		thread01.start();
		thread02.start();
		thread03.start();
	}

}
