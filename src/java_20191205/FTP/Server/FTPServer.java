package java_20191205.FTP.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {
	private int port;
	
	
	public FTPServer(int port) {
		this.port = port;
	}



	public void connect(){
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(port);
			
			System.out.println("waiting client...");
			socket = server.accept();
			System.out.println("Client accept : " + socket.getInetAddress().getHostAddress());
			
			FTPServerThread fst = new FTPServerThread(socket);
			//Thread t = new Thread(fst);
			fst.start();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		new FTPServer(3050).connect();
	}
}
