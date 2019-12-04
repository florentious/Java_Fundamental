package java_20191204.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private String ip;
	private int port;
	
	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	
	public void run() {
		Socket socket = null;
		
		OutputStream out = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream in = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		
		
		try {
			// 3. Socket 객체를 생성한다.
			// 4. 서버와 TCP 연결을 한다.(내부적으로 이루어짐)
			socket = new Socket(ip,port);
			// 6. 소켓을 이용해서 스트림 객체를 생성한다.
			out = socket.getOutputStream();			//OutputStream
			ow = new OutputStreamWriter(out);
			bw = new BufferedWriter(ow);
			//PrintWriter pw = new PrintWriter(bw);
			
			bw.write("안녕하세요. ");
			bw.newLine();
			bw.flush();
			
			
			// 9. Socket으로 입력스트림을 실행한다.
			
			in = socket.getInputStream();
			ir = new InputStreamReader(in);
			br = new BufferedReader(ir);
			
			String readLine = br.readLine();
			System.out.println(readLine);
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
				if(br!=null) br.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		new EchoClient("192.168.0.226",3000).run();
		
		new EchoClient("192.168.0.198",3000).run();
		
	}
	
	
}
