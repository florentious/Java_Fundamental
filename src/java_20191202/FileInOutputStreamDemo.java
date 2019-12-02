package java_20191202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;		//finally 블록에서 쓰기위해 선언과 생성자는 따로 생성
		
		try {
			fis = new FileInputStream("c:\\dev\\io\\2019\\12\\jdk.exe");
			fos = new FileOutputStream("c:\\dev\\io\\2019\\12\\jdk-2.exe");
			/*
			int readByte = 0;
			// fis.read() : 한개이 바이트를 읽어서 한개의 바이트를 반환한다. 더이상 읽을 바이트가 엇으면 -1 반환
			while((readByte = fis.read()) != -1) {
				// fos.wite() : 한개의 바이트를 쓴다.
				fos.write(readByte);
			}
			*/
			
			byte[] readBytes = new byte[1024*8];	// 8-10kb 잡는게 보편적
			int readByteCount = 0;
			long startTime = System.currentTimeMillis();
			//fis.read(readBytes) : 1024바이트 읽어서 readBytes에 저장하고 읽은 바이트수를 반환한다.
			while((readByteCount = fis.read(readBytes)) != -1) {
				// fos.write(readBytes,0,readByteCount) : readBytes 바이트 배열에 있는 데이터를 출력하되 처음(0,second parameter)부터
				// readByteCount(third parameter) 까지(다 안찰수도 있으니) 실행한다.
				fos.write(readBytes,0,readByteCount);
			}
			long endTime = System.currentTimeMillis();
			
			System.out.printf("Time : %d 초\n", endTime - startTime);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 에러가 나도, 안나도 무조건 수행됨
			try {
					if(fis != null) {
						fis.close();
					}
					if(fos != null) {
						fos.close();
					}
					
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}
		
		
		
		
	}
}
