package Echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerRecieveThread extends Thread {

	private Socket socket;
	public EchoServerRecieveThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		
		EchoServer.log("connected by client  " + remoteHostAddress + " : " + remotePort);
		
		try {
			//4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8")); // byte -> char -> string으로 변환..
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); //byte로 바꿀 필요 없이 String을 바로 사용 가능.
			
			while(true) {
				//5. 데이터 읽기
				String data = br.readLine(); //blocking
				
				if(data == null) {
					//remote에서 정상종료 즉 close 호출했다 그렇지 않은 경우 예외처리
					EchoServer.log("close by client");
					break;
				}
				
				EchoServer.log("received " + data);
				
				//6. 데이터 쓰기
				pw.println(data);
			}
		}catch(SocketException e) {
			EchoServer.log("Suddenly Closed by client");
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
	}
}
