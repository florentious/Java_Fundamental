package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		PrintStream ps = System.out;			// Destination 을 출력장치로 연결하겠다는 의미
		ps.println("Hello World!!");
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;	
		PrintStream ps1 = null;
		
		try {
			fis = new FileInputStream("c:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("c:\\dev\\io\\2019\\12\\pdf-printStream.zip");
			bos = new BufferedOutputStream(fos);
			
			ps1 = new PrintStream(bos,true);		// Destination을 파일로 연결
			
			int readByte = 0;
			
			while((readByte = bis.read()) != -1) {
				ps1.write(readByte);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(bis != null) bis.close();
				if(ps1 != null) ps1.close();				// fos, bos보다 먼저 닫아야 에러가 나지 않음.
				if(fos != null) fos.close();
				if(bos != null) bos.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		
	}
}
