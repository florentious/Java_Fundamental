package hello;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalSimpTest {
	
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		
		String curDate = sdf.format(cal.getTime());
		
		
		System.out.println("cal.date : " + curDate );
		
		System.out.println(cal.getTime());
		
		
		String startDate = null;
		String endDate = null;
		
		if(endDate == null || endDate.length() == 0) {
			endDate = sdf.format(cal.getTime());
		}
		
		if(startDate == null || startDate.length() ==0) {
			int sYear = Integer.parseInt(endDate.substring(0, 4));
			int sMonth = Integer.parseInt(endDate.substring(4,6));
			int sDay = Integer.parseInt(endDate.substring(6));
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(String.format("%04d",sYear));
			sb.append(String.format("%02d",sMonth-1));
			sb.append(String.format("%02d",sDay));
			
			startDate = sb.toString();
		}
		
		
		StringBuffer urlSB = new StringBuffer();
		
		urlSB.append("https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=");
		urlSB.append(startDate);
		urlSB.append("&end=");
		urlSB.append(endDate);
		
		String url = urlSB.toString();
		
		System.out.println(url);
		
		
		
		
		
		
	}
}
