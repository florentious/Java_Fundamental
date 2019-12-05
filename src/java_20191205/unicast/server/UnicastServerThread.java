package java_20191205.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	private Socket socket;
	
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			boolean isStop = false;
			while(!isStop) {
				String readLine = br.readLine();
				System.out.println(readLine);
				
				if(readLine.equals("exit")) {
					isStop = true;
				}
				
				bw.write(readLine);
				bw.newLine();
				bw.flush();
			}
			
			System.out.printf("Client %s (%s) normaly gone %n", socket.getInetAddress().getHostName(),socket.getInetAddress().getHostAddress());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Client abnormaly gone");
		} finally {
			try {
				if(bw!=null) bw.close();
				if(br!=null) br.close();
				if(socket!=null) socket.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
