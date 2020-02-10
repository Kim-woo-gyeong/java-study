package chat.client.win;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final int PORT = 5007;
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			name = name.replace(" ", ""); //공백 제거
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			
		}
		
		scanner.close();

		//1. socket 생성
		Socket socket = new Socket();
		
		try {
			//2. connect to server
			socket.connect(new InetSocketAddress("0.0.0.0", PORT));
			
			//3. iostream 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			//4. join protocol 요청 및 처리
			pw.println(name);
			
			//5. join 프로토콜이 성공 응답을 받으면 밑에 실행.
			new ChatWindow(name, socket).show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
