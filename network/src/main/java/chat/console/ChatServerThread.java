package chat.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.Hashtable;
import java.util.List;


public class ChatServerThread extends Thread {

	private Socket socket = null;
	private String nickName;
	public Hashtable<String, PrintWriter> hm;
	public PrintWriter pw;
	public BufferedReader br;
	
	public ChatServerThread(Socket socket, Hashtable<String, PrintWriter> hm) {
		this.socket = socket;
		this.hm = hm;
	}
	
	@Override
	public void run() {
		System.out.println("[thread server] connected");
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			
			//로그인 하기
			String nickname = br.readLine();
			dojoin(nickname);
			
			while(true) {
				String data = br.readLine();
				System.out.println(data);
				
				if(data == null) {
					System.out.println("[thread server] closed");
					doQuit(pw);
					break;
				} else if(data.contains("/to")) {
					String[] tokens = data.split(" ");// /to 닉네임 메시지 
					if(tokens.length == 1) {
						pw.println("귓속말 보낼 대상을 입력해주세요.");
					} else if(tokens.length == 2) {
						pw.println("귓속말을 보낼 메시지를 입력해 주세요.");
					} else {
						int a = tokens[1].length();
						String message = data.substring(a+4);
						Tomessage(tokens[1], message);
					}
				} else if("quit".equals(data)){
					System.out.println("[thread server] closed");
					doQuit(pw);
					break;
				}
				else {
					domessage(data);
				} 
				
			}
		} catch(SocketException e) {
			broadcast(nickName + " 님의 연결이 끊겼습니다.");
			System.out.println("채팅이 강제 종료 되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} 
			finally {
			try {
				if(socket != null && !socket.isClosed())
					socket.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//귓속말
	public void Tomessage(String name, String message) {
		PrintWriter printwriter = hm.get(name);
		if(printwriter == null) {
			pw.println(name + " 님은 퇴장했거나 아직 입장하지 않은 닉네임입니다. 다시 입력해주세요");
		}
		else {
			printwriter.println(nickName + " 님이 귓속말을 보냈습니다." + message);
		}
	}

	//나가기
	public void doQuit(Writer writer) {
		
		String data = nickName + " 님이 퇴장하셨습니다.";
		broadcast(data);
		removeWriter(hm);
		((PrintWriter)writer).println();
	}

	//제거
	public void removeWriter(Hashtable<String, PrintWriter> hm) {
		synchronized (hm) {
			hm.remove(nickName, pw);
		}
	}

	//로그인
	public void dojoin(String nickname) {
		this.nickName = nickname;
		synchronized (hm) {
			hm.put(nickName, pw);
		}
		String data = nickname + " 님이 입장하셨습니다.";
		broadcast(data);
	}
	
	//채팅
	public void domessage(String message) {
		String msg = nickName + ":" + message;
		broadcast(msg);
	}
	
	//브로드캐스트
	public void broadcast(String data) {
		synchronized ( hm ) {
			for(Writer pw : hm.values()) {
				PrintWriter printwriter = (PrintWriter)pw;
				printwriter.println(data);
				printwriter.flush();
			}
		}
	}
}
