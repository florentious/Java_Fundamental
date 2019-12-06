package java_20191205.FTP.Server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FTPServerThread extends Thread{
	private Socket socket;
	private String abs;

			
	public FTPServerThread(Socket socket) {
		this.socket = socket;
		this.abs = "c:\\dev\\io\\2019\\12\\";
	}
	
	public FTPServerThread(Socket socket, String abs) {
		this.socket = socket;
		this.abs = abs;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		OutputStream os = null;
		FileInputStream fis = null;
		
		
		
		try {
			// chaining and connecting
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			os = socket.getOutputStream();
			
			// get fileName
			String fileName = br.readLine();
			
			System.out.println(abs +fileName);
			
			fis = new FileInputStream(abs+fileName);
			
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while((readByteCount = fis.read()) != -1) {
				os.write(readBytes,0,readByteCount);
			}
			
			System.out.printf("Download[%s] : %s is Done%n",socket.getInetAddress().getHostAddress(),abs+fileName);		
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if(br != null) br.close();
				if(os != null) os.close();
				if(fis != null) fis.close();
				if(socket != null) socket.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	
	
	
}
