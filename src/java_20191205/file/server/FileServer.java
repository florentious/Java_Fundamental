package java_20191205.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private int port;
	
	
	
	public FileServer(int port) {
		this.port = port;
	}

	public void run() {
		
		ServerSocket serverSocket = null;
		FileServerThread fst = null;
		
		
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("waitting client....");
				Socket socket = serverSocket.accept();
				System.out.printf("client accept : %s%n",socket.getInetAddress().getHostAddress());
				
				fst = new FileServerThread(socket);
				Thread t = new Thread(fst);
				t.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	public static void main(String[] args) {
		new FileServer(3033).run();
	}
	
}
