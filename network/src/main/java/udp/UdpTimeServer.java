package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpTimeServer {
	private static final int PORT = 5004;
	public static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		
		try {
			//1. 소켓 생성
			socket = new DatagramSocket(PORT);
			SimpleDateFormat format;
			while(true) {
				//2. 데이터 받기(수신)
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket); //blocking
				
				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(data, 0, length, "UTF-8");
				
				System.out.println("[server] received : " + message);
				
				//3. 데이터 보내기(송신)
				byte[] sendData = message.getBytes("UTF-8");
				
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(socket!=null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
