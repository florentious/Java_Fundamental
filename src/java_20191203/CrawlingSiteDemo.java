package java_20191203;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingSiteDemo {
	public static void main(String[] args) {
		
		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end=20191203";
		
		Document doc = null;
		
		try {
			doc  = Jsoup.connect(url).get();
			System.out.println("Connect Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elements = doc.select(".cmc-table__table-wrapper-outer");
		System.out.println("Get data : " + !elements.isEmpty());
		
		Elements listElements = elements.select(".cmc-table-row sc-1ebpa92-0 kQmhAn");
		System.out.println("Get data : " + !elements.isEmpty());
		
		
		
		for (int i = 0; i < listElements.size(); i++) {
			Element list = listElements.get(i);
			String text = list.text();
			System.out.println(text);
		}
		
		
		
	}
}
