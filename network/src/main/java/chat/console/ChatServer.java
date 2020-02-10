/* 1. window 창과 콘솔 창 둘다 다중 채팅 가능
 * 2. 귓속말 구현
 * */

package chat.console;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ChatServer {

	private static final int PORT = 5007;
	static Hashtable<String, PrintWriter> hm;
	
	public static void main(String[] args) {
		ServerSocket serversocket = null;
		hm = new Hashtable<String, PrintWriter>();
		
		try {
			serversocket = new ServerSocket();
			serversocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			System.out.println("[server] server starts....");
			
			while(true) {
				Socket socket = serversocket.accept();
				new ChatServerThread(socket, hm).start();
			}
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		} finally {
			try {
				if(serversocket != null && !serversocket.isClosed()) {
					serversocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
