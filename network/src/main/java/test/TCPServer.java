package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//1-1. Time-Wait 시간에 socket에 포트번호를 할당 가능하게 하기 위해서
			serverSocket.setReuseAddress(true); // client가 먼저 닫혀도 server를 내리고 올리고 가능.. server에서는 필수다
			
			//2. 바인딩(Socket Address(IP Address + Port) Binding)
			serverSocket.bind(new InetSocketAddress("127.0.0.1",5000));
			
			//3.Accept
			Socket socket = serverSocket.accept();//blocking , 원격..?
			
			InetSocketAddress RemoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			InetAddress remoteInetAddress = RemoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = RemoteInetSocketAddress.getPort();
			
			System.out.println("[server]connected by client  " + remoteHostAddress + " : " + remotePort);
			
			try {
				//4. IOStream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					//5. 데이터 읽기
					byte[] buffer = new byte[256];
					
					int readByteCount = is.read(buffer); //blocking
					
					if(readByteCount == -1) {
						//remote에서 정상종료 즉 close 호출했다 그렇지 않은 경우 예외처리
						System.out.println("[server]close by client");
						return;
					}
					
					//encoding
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server]received " + data);
					
					//time out 예외처리 하기 위해 2초 잠드는 옵션?을 걸음.
					/*try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					//6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
			}catch(SocketException e) {
				System.out.println("[server] Sudden Closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(socket != null && !socket.isClosed())
						socket.close();
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
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

}
