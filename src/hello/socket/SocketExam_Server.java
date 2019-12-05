package hello.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExam_Server {
	private int port;
	
	public SocketExam_Server(int port) {
		this.port = port;
	}

	public void run() {
		ServerSocket server = null;
		
		try {
			server = new ServerSocket();
			
			Socket socket = server.accept();
			
			System.out.println("Accept Success");
			
			
			InputStream in = socket.getInputStream();
			InputStreamReader ir = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(ir);
			
			String readLine = br.readLine();
			System.out.println(socket.getInetAddress().getHostAddress() + " : " + readLine);
			
			
			String returnedString = null;
			returnedString = "Accept Success";
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter ow = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(ow);
			
			bw.write(returnedString);
			bw.newLine();
			bw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new SocketExam_Server(3000).run();
	}
}
