package Io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOuputStreamTest {

	public static void main(String[] args) {
		FileOutputStream fis = null;
		BufferedOutputStream bos = null;
	
		try {
			//기반 스트림(소스에 연결)
			fis = new FileOutputStream("test.txt");
			//보조스트림(기반스트림에 주로 연결)
			bos = new BufferedOutputStream(fis);
			
			for(int i = 'a'; i <= 'z'; i++) {
				//for(int i = 97; i < 122;i++)
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열 수 없습니다. - " + e);
		} catch(IOException e) {
			System.out.println("파일을 열 수 없습니다. - " + e);
		}finally {
			try {
				if(bos!=null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
}
