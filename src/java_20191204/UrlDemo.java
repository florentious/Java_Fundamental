package java_20191204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=421&aid=0004340528");
		
		String protocol = url.getProtocol();
		String host = url.getHost();
		
		int port = url.getPort();
		
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		System.out.printf("Protocol : %s%n", protocol);
		System.out.printf("Host : %s%n", host);
		System.out.printf("Port : %d%n", port);				// 없으면 -1리턴됨
		System.out.printf("Path : %s%n", path);
		System.out.printf("Query : %s%n", query);			// URL 쿼리나 패스같은것을 substring 하는데 사용함;
		System.out.printf("Reference : %s%n", ref);
		
		InputStream in = url.openStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		String readLine = null;
		while((readLine = br.readLine()) != null) {
			System.out.println(readLine);
		}
		
		if(br!=null) br.close();
		
		
	}
}
