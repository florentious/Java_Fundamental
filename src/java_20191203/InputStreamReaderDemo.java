package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputStreamReaderDemo {
	
	public static void main(String[] args) {
		
		System.out.print("Input > ");
		InputStream in = System.in;				// source(keyborad/system.in)
		
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		isr = new InputStreamReader(in);
		br = new BufferedReader(isr);
		
		
		try {
			fw = new FileWriter("c:\\dev\\io\\2019\\12\\test.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);
			
			String readLine = null;
			while((readLine = br.readLine()) != null) {
				//readLine = br.readLine();	// read()하기전까지 함. system.in의 경우키보드 입력을 기다리다 엔터를 치면 읽는다.
				if(readLine.equals("exit")) break;
				
				System.out.println(readLine);
				System.out.print("Input > ");
				
				pw.println(readLine);
				
			}
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		
		} finally {
			try {
				if(in != null) in.close();
				if(br != null) br.close();
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
