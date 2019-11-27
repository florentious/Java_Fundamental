package java_20191127;

import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		
		// 자바 1.4 이전버전에서는 primitive data type을 collection 에 저장할 수 없었기 때문에 primitive data type을 
		// 객체화 할수 있는 reference type인 Wrapper class로 변환하여 저장해야한다.
		
		ArrayList list = new ArrayList();
		list.add(new Integer(1));
		list.add(new Integer(2));
		
		Integer il = (Integer) list.get(0);
		Integer i2 = (Integer) list.get(1);
		
		int a = il.intValue() + i2.intValue();
		
		//java 1.5 or java 5.0 이후
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();	//arraylist에 전부 integer로 한정하는것 = generic
		
		list1.add(1);		//auto-boxing
		list1.add(2);		//auto-boxing
		
		Integer i3 = list1.get(0);
		Integer i4 = list1.get(1);
		
		int b = i3 + i4;	//auto-unboxing
		
		//primitive를 integer로 바꿀때
		String str = Integer.toString(10);
		String str1 = String.valueOf(10);
		
		// 문자열을 integer로 바꿀때
		int d = Integer.parseInt("100");
		 
		
		
	}
}
