package hello.ftp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FTPServer {

	private int port;

	public FTPServer() {
		this.port = 6060;
	}

	public FTPServer(int port) {
		this.port = port;
	}

	public void connect() {
		ServerSocket server = null;
		Socket socket = null;

		while (true) {
			try {
				server = new ServerSocket(port);
				System.out.println("Server On , Waiting Client ");
				socket = server.accept();
				System.out.println("Client accept : " + socket.getInetAddress().getHostAddress());

				FileServerThread fst = new FileServerThread(socket);
				fst.start();

			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
		}
		
		
	}

	public static void main(String[] args) {
		new FTPServer(6060).connect();
	}
}
