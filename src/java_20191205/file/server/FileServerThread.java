package java_20191205.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable {
	
	private Socket socket;
	
	public FileServerThread() {
	}


	public FileServerThread(Socket socket) {
		this.socket = socket;
	}




	@Override
	public void run() {
		
		BufferedReader br = null;
		FileInputStream fis = null;
		
		OutputStream os = null;
		
		String abs = "C:\\dev\\io\\2019\\12\\";
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			os = socket.getOutputStream();
			
			String fileName = br.readLine();
			
			fis = new FileInputStream(abs+fileName);
			
			
			//System.out.println((fis == null));
			System.out.printf("%s : download -  %s", socket.getInetAddress().getHostAddress(),abs+fileName);
			//System.out.println(abs+fileName);
			
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while((readByteCount = fis.read(readBytes)) != -1) {
				os.write(readBytes, 0, readByteCount);
			} 
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
				if(os!=null) os.close();
				if(br!=null) br.close();
				if(socket!=null) socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
