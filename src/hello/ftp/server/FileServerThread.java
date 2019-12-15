package hello.ftp.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread extends Thread{
	private String abs;
	
	
	public FileServerThread(Socket socket) {
		abs = "d:\\dev\\ioTest\\server\\";
		
		BufferedReader br = null;
		FileInputStream fis = null;
		OutputStream os = null;
		
		new File(abs).mkdirs();
		
		
		
		try {
			
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String fileName = br.readLine();
			
			fis = new FileInputStream(abs+fileName);	// file inputStream
			os = socket.getOutputStream();
			
			System.out.printf("Download [ %s ] - %s%n",socket.getInetAddress().getHostAddress(),abs+fileName);
			
			
			int readByteCount = 0;
			byte[] readByte = new byte[1024*8];
			
			while((readByteCount = fis.read(readByte)) != -1) {
				os.write(readByte, 0, readByteCount);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(fis!=null) fis.close();
				if(os!=null) os.close();
				if(socket!=null) socket.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	
}
