package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
	private static final int PORT = 5004;
	public static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			//1. socket 생성
			socket = new DatagramSocket(PORT);
			
			while(true) {
				//2. 데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); //blocking
				
				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(data, 0, length, "UTF-8");
				
				System.out.println("[server] received : " + message);
				
				//3. 데이터 송신
				byte[] sendData = message.getBytes("UTF-8");
				//send는 이미 바이트 형이기 때문에 data를 받으면 됨. receivePacket안에는 보낸 사람 주소가 들어있음..받는 사람 주소
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
			}
			
		}catch (SocketException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}finally {
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
