package Io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			//기반 스트림
			fr = new FileReader("./src/Io/BufferedReaderTest.java");
			//보조 스트림
			br = new BufferedReader(fr);
			
			String line = null;
			int count = 0;
			while((line = br.readLine())!=null) {
				count++;
				System.out.print(count);
				System.out.print(" : ");
				System.out.print(line);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다. - " + e);
		}catch (IOException e) {
			System.out.println("파일이 없습니다. - " + e);
		}finally {
			try {
				if(br!=null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
