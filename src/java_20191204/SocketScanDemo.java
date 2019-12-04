package java_20191204;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketScanDemo {
	public static void main(String[] args) {
		
		Socket socket = null;
		
		for (int i = 80; i <= 445 ; i++) {
			// Socket 객체가 생성되었다는 의미는 hos, port로 통신할 수 있는 이야기 의미, 이는 해당 host와 포트에 연결되었다는 의미이다
			try {
				socket = new Socket("13.209.180.253",i);
				System.out.println(i+ " number is used");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				//System.err.println("No Exist host");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//System.err.println(i+ " number ain't used");
			}
		}
		
	}
}
