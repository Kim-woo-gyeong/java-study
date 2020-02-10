package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	public static void main(String[] args) {
		
		Socket socket = null;
		try {
			//1. 소켓 생성
			socket = new Socket();
			
			//1-1. 소켓 버퍼 사이즈 확인
			int receiveBuffersize = socket.getReceiveBufferSize();
			int sendBuffersize = socket.getSendBufferSize();
			System.out.println(receiveBuffersize + ":" + sendBuffersize);
			
			//1-2. 소켓 버퍼 사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			
			receiveBuffersize = socket.getReceiveBufferSize();
			sendBuffersize = socket.getSendBufferSize();
			System.out.println(receiveBuffersize + ":" + sendBuffersize);
			
			//1-3. SO_NODELAY(Nagle 알고리즘 OFF)
			socket.setTcpNoDelay(true); // NAGLE 알고리즘을 끈다는 것은 DELAY를 주지 않는다.
			
			//1-4. SO_TimeOut
			socket.setSoTimeout(1000); //1초동안 데이터가 안오면 예외처리
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress("127.0.0.1", 5000));
			System.out.println("[client]connected");
			
			//3. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. 쓰기
			String data = "Hello World";
			os.write(data.getBytes("utf-8"));
			
			//5. 읽기
			
			byte[] buffer = new byte[256];
			
			int readByteCount = is.read(buffer); //blocking
			
			if(readByteCount == -1) {
				//Server에서 정상종료  그렇지 않은 경우 예외처리
				System.out.println("[client]close by server");
				return;
			}
			
			//encoding
			data = new String(buffer, 0, readByteCount, "UTF-8");
			System.out.println("[client]receved : " + data);
		} catch (SocketTimeoutException e) { 
			System.out.println("[client] time out");
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			/*
			 * try { if(socket !=null && !socket.isClosed()) //socket.close(); } catch
			 * (IOException e) { e.printStackTrace(); }
			 */		}
	}

}
