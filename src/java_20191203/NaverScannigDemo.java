package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

public class NaverScannigDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com/");
		
		InputStream in = url.openStream();
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		File f = new File("c:\\dev\\io\\2019\\12\\2");
		System.out.println(f.mkdirs());
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		
		// 1. InputStream을 InputStreamReader로 2byte char형태로 받아올것
		// 2. InputStreamReader를 BufferedReader로 chainning 한다
		// 3. BufferedReader로 읽은 정보(HTML)를 c:\dev\io\2019\12\2\naver.html 파일로 저장
		
		isr = new InputStreamReader(in);
		br = new BufferedReader(isr);
		
		fw = new FileWriter("c:\\dev\\io\\2019\\12\\2\\naver.html");
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw, true);
		
		String readLine = null;
		
		while((readLine = br.readLine()) != null) {
			//System.out.println(readLine);
			pw.println(readLine);
		}
		
		
		if(pw != null) pw.close();
		if(br != null) br.close();
		
	}
}
