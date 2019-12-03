package java_20191203;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverSportCrawlingDemo {

	
	public static void main(String[] args) {
		
		String url = "https://sports.news.naver.com/index.nhn";
		
		Document doc = null;
		Document doc2 = null;
		
		try {
			doc = Jsoup.connect(url).get();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements elements = doc.select("#news_category_contents_2_0");
		
		Elements listElements = elements.select("ul li");
		
		for (int i = 0; i < listElements.size(); i++) {
			/*
			Element listElement = listElements.get(i);
			String title = listElement.text();
			System.out.println(text);
			*/
			Element liElement = listElements.get(i);
			String href = liElement.select("a").attr("abs:href");	//abs 절대주소: https://www.naver.com/
			
			try {
				doc2 = Jsoup.connect(href).get();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			Elements ele = doc2.select("#newsEndContents");			// 집에 들어가서 확인할것
			String content = ele.text();
			String title = liElement.text();
			System.out.println(title + " : " + content);
			
			
		}
		
				
		
	}
}
