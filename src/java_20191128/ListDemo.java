package java_20191128;

import java.util.ArrayList;

public class ListDemo {
	public static void main(String[] args) {
		// ArrayList : 순서가 있고, 데이터(객체)의 중복을 허용한다.
		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(new Product(1,"terra",2500));
		list.add(new Product(2,"신라면",1000));
		list.add(new Product(3,"서울우유",3000));
		
		// 코드가 별로 좋지 않음
		for (int i = 0; i < list.size(); i++) {
			Product temp = list.get(i);
			System.out.println(temp);
			
		}
		
		// 모두 삭제 list.remove(int index)
		/*
		while(list.isEmpty()==false) {
			list.remove(0);
		}
		*/
		
		// list.size()는 실시간으로 변동해서 일반적으로 list.remove(0)을 대입했을때 마지막의 0을지우지 못함.
		for(int i=0;i<list.size();i++) {
			list.remove(i--);
		}
		
		// enhanced for loop 출력가능(제너릭으로 선언된 경우 같은 타입이기에 가능함)
		for (Product temp : list) {
			System.out.println(temp);
		}
		
		
	}
}

class Product {
	int number;
	String name;
	double price;
	public Product(int number, String name, double price) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
