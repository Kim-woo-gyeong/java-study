package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.sound.midi.Receiver;

public class UdpTimeClient {
	private static final int PORT = 5004;
	public static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		Scanner scanner = null;
		DatagramSocket socket = null;
		
		
		try {
			scanner = new Scanner(System.in);
			socket = new DatagramSocket();
			SimpleDateFormat format;
			while(true) {
				System.out.println(">>");
				String line = scanner.nextLine();
				
				if("quit".equals(line)) {
					break;
				}
				
				//데이터 쓰기
				byte[] sendData = line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, new InetSocketAddress("127.0.0.1", PORT));
				
				//데이터 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket);
				
				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
				String Datedata = format.format(new Date());
				String message = new String(data, 0, length, "UTF-8");
				
				if(length == 0) {
					message = Datedata;
				}
				
				System.out.println("<<"+message);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
