package Echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	private static final int PORT = 4000;
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(Socket Address(IP Address + Port) Binding)
			serverSocket.bind(new InetSocketAddress("127.0.0.1",PORT));
			log("starts...[port : " + PORT + " ]");
			
			//3.Accept
			while(true) {
				Socket socket = serverSocket.accept();//blocking , 원격..?
				new EchoServerRecieveThread(socket).start();
			}
			/*InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
			
			log("connected by client  " + remoteHostAddress + " : " + remotePort);
			
			try {
				//4. IOStream 생성(받아오기)
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); // byte -> char -> string으로 변환..
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); //byte로 바꿀 필요 없이 String을 바로 사용 가능.
				
				while(true) {
					//5. 데이터 읽기
					String data = br.readLine(); //blocking
					
					if(data == null) {
						//remote에서 정상종료 즉 close 호출했다 그렇지 않은 경우 예외처리
						log("close by client");
						break;
					}
					
					log("received " + data);
					
					//6. 데이터 쓰기
					pw.println(data);
				}
			}catch(SocketException e) {
				log("Suddenly Closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(socket != null && !socket.isClosed())
						socket.close();
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void log(String log) {
		System.out.println("[server# "+ Thread.currentThread().getId() + " ] " + log);
	}
}
