package java_20191202;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutputStreamDemo {
	
	
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;		
		try {
			fis = new FileInputStream("c:\\dev\\io\\2019\\12\\pdf.zip");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("c:\\dev\\io\\2019\\12\\pdf-fileIO.zip");
			bos = new BufferedOutputStream(fos);
			
			/*
			int readByte = 0;
			
			long start = System.currentTimeMillis();
			while((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}
			long end = System.currentTimeMillis();
			
			System.out.printf("Time : %d%n", end-start);
			*/
			/*
			int readByte = 0;
			
			long start = System.currentTimeMillis();
			while((readByte = bis.read()) != -1) {
				bos.write(readByte);
			}
			bos.flush();									// 안하면 마지막 열차가 안보내짐; 사이즈 차이
			long end = System.currentTimeMillis();
			
			System.out.printf("Time : %d%n", end-start);
			*/
			
			int readByteCount = 0;
			byte[] readBytes = new byte[1024*8];
			
			long start = System.currentTimeMillis();
			while((readByteCount = fis.read(readBytes)) != -1) {		// 굳이 버터를 쓸 필요가 없다
				fos.write(readBytes,0,readByteCount);
			}
			long end = System.currentTimeMillis();
			
			System.out.printf("Time : %d\n",end-start);
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(bis != null) bis.close();
				if(fos != null) fos.close();
				if(bos != null) bos.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	}
}
