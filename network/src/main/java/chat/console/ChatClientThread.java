package chat.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {

	private Socket socket = null;
	private BufferedReader br = null;

	public ChatClientThread(Socket socket, BufferedReader br) {
		this.socket = socket;
		this.br = br;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			while (true) {
				String line = br.readLine();
				
				if (line == null) {
					System.out.println("[client] closed.....");
					socket.close();
					break;
				}

				System.out.println(line);
			}

		} catch (SocketException e) {
			System.out.println("채팅이 종료되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && (!socket.isClosed())) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
