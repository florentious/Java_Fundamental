package hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("D:\\dev\\io\\test.txt");
			fos = new FileOutputStream("D:\\dev\\io\\test2.txt");
			/*
			int readByte = 0;
			while((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}
			*/
			
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
	}
}
