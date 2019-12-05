package java_20191205.file.client;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {
	
	private String ip;
	private int port;
	
	
	public FileClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	
	public void run() {
		Socket socket = null;
		BufferedWriter bw = null;
		
		InputStream in = null;
		FileOutputStream fos = null;
		
		try {
			socket = new Socket(ip,port);
			String abs = "c:\\dev\\pdf\\";
			String needFileName = "scott.sql";
			
			// Stream Chaining 
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			in = socket.getInputStream();
			fos = new FileOutputStream(abs+needFileName);
			
			bw.write(needFileName);
			bw.newLine();
			bw.flush();
			
			
			byte[] readBytes = new byte[1024*8];
			int readCount = 0;
			
			while((readCount = in.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readCount);
			}
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fos!=null) fos.close();
				if(in!=null) in.close();
				if(bw!=null) bw.close();
				if(socket!=null) socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	} 



	public static void main(String[] args) {
		new FileClient("192.168.0.203",3033).run();			//port FTP 21번은 파일은 안넘어가는데 텍스트 파일은 안넘어간다리. 그냥 채팅용이라 그걸 읽어서 던져서 그런가?
	}
}
