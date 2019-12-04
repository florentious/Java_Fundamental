package java_20191204.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private int port;

	public EchoServer(int port) {
		this.port = port;
	}
	
	public void run() {
		ServerSocket serverSocket = null;
		
		try {
			// 1. ServerSocket 객체를 생성한다.
			serverSocket = new ServerSocket(port);
			
			while(true) {
				// accept() 메서드는 클라이언트 접속을 기다리다가 클라이언트가 접속하면 클라이언트와 통신할 수 있는 Socket 객체를 반환한다.
				// 2. 서버소켓으로 접속을 기다린다.
				// 5. 클라이언트와 통신할 수 있는 소켓 객체를 반환한다. 
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트 접속을 기다리고 있습니다. ip : " + socket.getInetAddress().getHostAddress());
				// hostAddress 얻어오는방법
				
				
				// 7. 소켓으로 입력 스트림을 생성한다.
				InputStream in = socket.getInputStream();
				InputStreamReader ir = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(ir);
				
				String readLine = br.readLine();				// 반복문 굳이 필요없음
				System.out.println(readLine);
				
				// 8. Socket으로 출력 스트림을 생성한다.
				
			
				
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter ow = new OutputStreamWriter(out);
				BufferedWriter bw = new BufferedWriter(ow);
				
				bw.write(readLine);
				bw.newLine();
				bw.flush();
				
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static void main(String[] args) {
		new EchoServer(3000).run();
		
	}
}
