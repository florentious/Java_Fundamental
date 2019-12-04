package hello;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingTest {
	public static void main(String[] args) {
		
		String url = "https://docs.oracle.com/javase/8/docs/api/";
		
		Document doc =null;
		
		try {
			doc = Jsoup.connect(url).get();
			System.out.println("get Document Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Elements elements = doc.select(".overviewSummary");
		System.out.println(elements.isEmpty());
		
		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);
			String text = element.text();
			System.out.println(text);
		}
		
		
		
	}
}
