package chat.client.win;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private String name;
	BufferedReader br;
	
	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.name = name;
		this.socket = socket;
	}

	public void show() {


		ChatClientThread thread = new ChatClientThread();
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		
		/*
		 * 1. UI초기화
		 * */
		
		// Textfield
		textField.setColumns(80);
		
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char KeyCode = e.getKeyChar();
				if(KeyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
		
		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		textArea.append("1. 귓속말 이용법 < /to 닉네임 메시지 >\n");
		textArea.append("    *주의 사항 : 띄어쓰기 필수*\n");
		textArea.append("2. 채팅 나가기 < quit >\n");
		textArea.append("=================================\n");
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		/*
		 * 2. IOStream 초기화
		 * */
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * 3. 쓰레드 생성 작업
		 * */
		
		thread.start();
		
	}
	
	private void sendMessage() {
		
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			String message = textField.getText();
			
			if("quit".equals(message)) {
				String line = message;
				pw.println(line);
				System.exit(0);
			} 
			else {
				String line = message;
				pw.println(line);
			}
			
			textField.setText("");
			textField.requestFocusInWindow();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public class ChatClientThread extends Thread{ //inner class

		@Override
		public void run() {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

				while (true) {
					String msg = br.readLine();
					
					if(msg == null) {
						socket.close();
						break;
					}
					
					textArea.append(msg);
					textArea.append("\n");
				}

			} catch (SocketException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
	}
}
