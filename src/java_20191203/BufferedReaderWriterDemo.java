package java_20191203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 2byte char 형으로 읽을때 많이씀
public class BufferedReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			fr = new FileReader("c:\\dev\\io\\2019\\12\\test.txt");
			fw = new FileWriter("c:\\dev\\io\\2019\\12\\test_buffered_copy.txt");
			
			//chaining
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			
			
			String readLine = null;
			
			while((readLine = br.readLine()) != null) {
				bw.write(readLine);							//개행 기준으로 잘라서 넣기때문에 개행을 따로 넣어줘야함
				bw.newLine();	
				
			}
			bw.flush();										// bw.flush(); 를 buffered 사용할때는 꼭 넣어줄것
			
			
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
