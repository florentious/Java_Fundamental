package java_20191203;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingThread extends Thread {
	private String fileName;

	// constructor
	public CrawlingThread() {

	}

	public CrawlingThread(String fileName) {
		this.fileName = fileName;
	}
	

	@Override
	public void run() {
		//int count = 0;
		
		while(true) {
			/*
			count++;
			String name = fileName.substring(0, fileName.lastIndexOf("."));
			String extension = fileName.substring(fileName.lastIndexOf("."));
			fileName = name+count+extension;
			*/
			
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String endDate = sdf.format(c.getTime());
			
			
			// TODO Auto-generated method stub
			String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end="+endDate;
			
				
			Document doc = null;
	
			FileWriter fw = null;
			BufferedWriter bw = null;
			PrintWriter pw = null;
	
			try {
				doc = Jsoup.connect(url).get();
				//System.out.println("Connect Success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			Elements elements = doc.select(".cmc-table__table-wrapper-outer table tbody tr");
	
			// System.out.println("Get data : " + !elements.isEmpty());
	
			try {
				fw = new FileWriter("c:\\dev\\io\\2019\\12\\"+fileName);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
	
				//System.out.println("Date\t\tOpen\t\tHigh\t\tLow\t\tClose\t\tVolume\t\tCap");
				pw.println("Date\t\tOpen\t\tHigh\t\tLow\t\tClose\t\tVolume\t\tCap");
	
				for (int i = 0; i < elements.size(); i++) {
					Element trElement = elements.get(i);
					String date = trElement.child(0).text();
					String open = trElement.child(1).text();
					String high = trElement.child(2).text();
					String low = trElement.child(3).text();
					String close = trElement.child(4).text();
					String volume = trElement.child(5).text();
					String cap = trElement.child(6).text();
	
					String format = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s%n", date, open, high, low, close, volume,	cap);
					// system.out
					//System.out.print(format);
	
					// file
					pw.print(format);
	
				}
	
			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (pw != null) pw.close();
			}
			
			try {
				Thread.sleep(1000*60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	//end while

	}

}
