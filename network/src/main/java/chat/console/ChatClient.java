package chat.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	private static final int PORT = 5007;
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			//키보드 연결
			scanner = new Scanner(System.in);
			//socket 생성
			socket = new Socket();
			//연결
			socket.connect(new InetSocketAddress("0.0.0.0", PORT));
			System.out.println("[client] connect..");
			
			//br, pw 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			//join 프로토콜
			System.out.print("닉네임을 입력하세요>>");
			String nickname = scanner.nextLine();
			pw.println(nickname);
			pw.flush();
			
			// chatclient Thread 시작
			new ChatClientThread(socket,br).start();
			
			while(true) {
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if("quit".equals(line)) {
					pw.println(line);
					break;
				} else {
					pw.println(line);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && (!socket.isClosed())) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
