package java_20191203;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetToText {

	
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("c:\\dev\\io\\2019\\12\\crawling.txt");
			br = new BufferedReader(fr);
			
			String readLine = null;
			String[] data = null;
			
			while((readLine = br.readLine()) != null) {
				data = readLine.split("\t");
				
				String date = data[0];
				String open = data[1];
				String high = data[2];
				String low = data[3];
				String close = data[4];
				String volume = data[5];
				String cap = data[6];
				
				open.replaceAll(",", "");
				high.replaceAll(",", "");
				low.replaceAll(",", "");
				close.replaceAll(",", "");
				volume.replaceAll(",", "");
				cap.replaceAll(",", "");
				
				System.out.printf("%s\t%f\t%f\t%f\t%f\t%f\t%f",date,Double.parseDouble(open),Double.parseDouble(high),Double.parseDouble(low),Double.parseDouble(close),Integer.parseInt(volume),Integer.parseInt(cap));
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
