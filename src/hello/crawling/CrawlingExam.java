package hello.crawling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingExam {
	private String url;
	
	
	public void crawling() {
		FileInputStream fis = null;
		Properties prop = null;
		
		try {
			fis = new FileInputStream("C:\\dev\\workspace\\Java_Fundamental\\src\\hello\\crawling\\info.properties");
			prop = new Properties();
			prop.load(fis);
			
			url = prop.getProperty("url2");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elements = doc.select(".list-body.box-body.orange-body .list-desc");
		
		for (int i = 0; i < elements.size(); i++) {
			Element ele = elements.get(i);
			int index = 0;
			String head = ele.child(index++).text();
			String next = ele.child(index++).text();
			String nextMore = ele.child(index++).text();
			
			System.out.printf("%s\t\t %s%n",head,nextMore);
			
			
			
		}
		
		
	}

	public static void main(String[] args) {
		new CrawlingExam().crawling();
	}
}
