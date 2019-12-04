package java_20191204;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress i = InetAddress.getLocalHost();							// Exception : UnknownHostException
		System.out.printf("host Name : %s%n", i.getHostName());
		System.out.printf("host IP adress : %s%n", i.getHostAddress());
		
		InetAddress i2 = InetAddress.getByName("naver.com");
		System.out.printf("host Name : %s%n", i2.getHostName());
		System.out.printf("host IP adress : %s%n", i2.getHostAddress());
		
		
		
	}
}
