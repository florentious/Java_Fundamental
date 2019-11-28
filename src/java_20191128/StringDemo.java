package java_20191128;

public class StringDemo {
	public static void main(String[] args) {
		String str = "111111-1111118";
		
		//charAt 문자하나 꺼내서 확인할때
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		// str = str+"abcd"; 와 같은 의미
		str = str.concat("abcd");
		
		String fileName1 = "abc.zip";
		
		if(fileName1.endsWith(".zip")) {
			System.out.println("zip file");
		}else if(fileName1.endsWith(".ppt")) {
			System.out.println("ppt file");
		}
		
		String uri = "artist/index.jsp";
		if(uri.startsWith("artist")) {
			System.out.println("작가페이지입니다.");
		} else if(uri.startsWith("exhibition/index.jsp")) {
			System.out.println("전시 페이지입니다.");
		}
		
		System.out.println("abc".equalsIgnoreCase("aBC"));
		
		String strByte1 = "a";
		String strByte2 = "성";
		System.out.println(strByte1.getBytes().length);
		System.out.println(strByte2.getBytes().length);
		
		// str = "111111-1111118"
		System.out.println(str.indexOf("-"));
		System.out.println(str.substring(0,str.indexOf("-")));				// 거의 공식
		System.out.println(str.substring(str.lastIndexOf("-")+1));		
		
		String fileName = "abc.bde.fafb.asdf.ppt";
		System.out.println(fileName.lastIndexOf("."));
		System.out.println(fileName.substring(fileName.lastIndexOf(".")));
		
		String content = "abc\nabc\nabc\nabc";								// 정규표현법 - 개행문자같은것
		System.out.println(content.replaceAll("\n", "<br>"));
		
		String s1 = "abc";
		String s2 = "abc ";
		System.out.println(s1.equals(s2));
		System.out.println(s1.trim().equals(s2.trim()));
		
		// primitive data type => string
		s1 = String.valueOf(100);
		s1 = Integer.toString(100);
		
		String phoneNumber = "010-3024-1703";
		String[] temp = phoneNumber.split("-");
		String phone = new String();
		for(int i=0;i< temp.length;i++) {
			phone = phone.concat(temp[i]);
		}
		
		for (String string : temp) {
			System.out.println(string);
		}
		
		System.out.println(phone);
		
		str = String.format("%3$,10.3f %,10.1f %,10.0f\n", 10000.00,20000.00,30000.00);
		System.out.println(str);
		
		System.out.printf("%d%n", 100);
		System.out.format("%d%n", 100);
		
		
	}
}
