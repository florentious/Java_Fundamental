package java_20191205.multicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServerThread implements Runnable {
	private Socket socket;
	private ArrayList<MulticastServerThread> list;
	
	private BufferedReader br;
	private BufferedWriter bw;
	
	
	public MulticastServerThread() {
	}

	public MulticastServerThread(Socket socket, ArrayList<MulticastServerThread> list) {
		this.socket = socket;
		this.list = list;
		this.br = null;
		this.bw = null;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			boolean isStop = false;
			String readLine = null;
			while(!isStop) {
				readLine = br.readLine();
				System.out.println(readLine);
				
				if(readLine.equals("exit")) {
					isStop = true;
					sendMessage(readLine);
				} else {
					broadCast(readLine);
				}
				
			}
			System.out.printf("Client %s (%s) normaly gone %n", readLine.substring(0, readLine.indexOf(":")),socket.getInetAddress().getHostAddress());
			list.remove(this);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Client abnormaly gone");
			list.remove(this);
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
	
	public void sendMessage(String message) throws IOException {
		bw.write(message);
		bw.newLine();
		bw.flush();
	}

	private void broadCast(String readLine) throws IOException {
		// TODO Auto-generated method stub
		
		for(MulticastServerThread mst : list) {
			mst.sendMessage(readLine);
		}
	}
	
	
	
}
