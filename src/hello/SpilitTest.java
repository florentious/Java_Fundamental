package hello;

public class SpilitTest {
	public static String callByTest() {
		
		return "\\.";
	}
	
	
	public static void main(String[] args) {
		String s = "2019.12.25";
		String[] ch = {" ","/","\\.","-"};
		
		System.out.println(s.contains(callByTest()));
		String[] sp = s.split(callByTest());
		
		
		/*
		for (String string : sp) {
			System.out.println(string);
		}
		*/
		int[] spN = new int[sp.length];
		for(int i=0;i<spN.length;i++) {
			spN[i] = Integer.parseInt(sp[i]);
		}
		
		for (int i : spN) {
			System.out.println(i);
		}
		
	}
}
