package java_20191204;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketDemo {
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		for (int i = 1; i < 65536; i++) {
			try {
				// serverSocket 클래스는 해당 서버의  port번호로 사용할수 있으면 ServerSocket 객체를 사용할수 있음
				// 그렇지 않으면 예외발생함.
				// 예외가 발생한다는 이야기는 해당 port를 사용한다는 의미
				serverSocket = new ServerSocket(i);
				//System.out.println(i+" can use");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(i+" can't use");
			}
		}
		
	}
}
