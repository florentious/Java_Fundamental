package java_20191205.unicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private int port;

	public UnicastServer(int port) {
		this.port = port;
	}


	public void run() {
		ServerSocket serverSocket = null;
		UnicastServerThread ust = null;
		
		
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("Waiting Now..");
				Socket socket = serverSocket.accept();		// serverSocket.accept;
				
				System.out.println("accpet client ip : " + socket.getInetAddress().getHostAddress());
				
				
				// THread Server-argument : socket obj
				ust = new UnicastServerThread(socket);
				Thread t = new Thread(ust);
				t.start();
				
				
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	
	public static void main(String[] args) {
		new UnicastServer(3000).run();
	}
	
}
