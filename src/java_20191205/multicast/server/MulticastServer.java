package java_20191205.multicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServer {
	private int port;
	private ArrayList<MulticastServerThread> list;

	public MulticastServer(int port) {
		this.port = port;
		this.list = new ArrayList<MulticastServerThread>(); 
	}


	public void run() {
		ServerSocket serverSocket = null;
		MulticastServerThread ust = null;
		
		
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("Waiting Now..");
				Socket socket = serverSocket.accept();		// serverSocket.accept;
				
				System.out.println("accpet client ip : " + socket.getInetAddress().getHostAddress());
				
				
				
				// THread Server-argument : socket obj
				ust = new MulticastServerThread(socket, list);
				list.add(ust);
				System.out.println("client count : " + list.size());
				
				Thread t = new Thread(ust);
				t.start();
				
				
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	
	public static void main(String[] args) {
		new MulticastServer(3000).run();
	}
	
}
