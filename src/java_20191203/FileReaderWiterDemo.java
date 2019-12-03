package java_20191203;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWiterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("c:\\dev\\io\\2019\\12\\test.txt");
			fw = new FileWriter("c:\\dev\\io\\2019\\12\\test_fileReader_copy.txt");
			
			/*
			// 한 문자씩 읽기
			int readChar = 0;
			while((readChar = fr.read()) != -1) {
				System.out.print((char)readChar);			// 출력장치 1. 모니터
				fw.write(readChar);							// 출력장치 2. 파일시스템
			}
			*/
			
			int readCharCount = 0;
			char[] readChars = new char[1024*8];
			while((readCharCount = fr.read(readChars)) != -1) {					
				//System.out.print(readChars);									// 자바 api 한계가 없어서 중복된거 다시 출력하는 문제가 생김
				//System.out.println(new String(readChars));					// 이런식으로 추가하면 마지막에 끝을 알수 없어 전에 복사한 것을 출력함
				System.out.print(new String(readChars,0,readCharCount));		// 이와같이 끝을 한정해야됨
				fw.write(readChars,0,readCharCount);
				//fw.write(new String(readChars,0,readCharCount)); 				// fw.write에 문자열로 라이트하는것
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) fr.close();
				if(fw != null) fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
