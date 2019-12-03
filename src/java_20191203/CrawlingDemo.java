package java_20191203;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {

	
	public static void main(String[] args) {
		
		String url = "http://imbc.com/";
		// HTML 문서 전체를 관리하기 위한 객체
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
			System.out.println("get Document success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elements = doc.select(".con-wrap.notice-wrap");				// id : '#' , class : '.', css문법 사용
		//title
		Elements titleElements = elements.select("h3");
		String noticeTitle = titleElements.text();
		System.out.println(noticeTitle);
		
		
		//sub
		Elements liElements = elements.select(".notice-list ul li");			// 하부단은 공백으로 표시
		for (int i = 0; i < liElements.size(); i++) {
			Element liElement = liElements.get(i);
			String text = liElement.text();
			System.out.println(text);
		}
		
		
	}
}
