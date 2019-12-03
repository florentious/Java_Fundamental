package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 가장 일반적인 방법
public class PrintWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			
			fr = new FileReader("c:\\dev\\io\\2019\\12\\test.txt");
			fw = new FileWriter("c:\\dev\\io\\2019\\12\\test_buffered_copy.txt");
			
			//chaining
			br = new BufferedReader(fr);		// Stream-Chainning
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw,true);		// ture => auto flush
			
			
			String readLine = null;
			
			while((readLine = br.readLine()) != null) {
				pw.println(readLine);
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) fr.close();
				if(br != null) br.close();
				if(bw != null) bw.close();				
				//if(fw != null) fw.close();
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}
