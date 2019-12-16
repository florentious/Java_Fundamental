package hello.crawling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlingExam {
	private static String url;
	
	public CrawlingExam() {
		Properties prop = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("");
			prop.load(fis);
			
			this.url = prop.getProperty(url);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void crawling() {
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elements = doc.select("query");
		
		
	}
	
	public static void main(String[] args) {
		new CrawlingExam().crawling();
	}
}
