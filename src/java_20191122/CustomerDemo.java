package java_20191122;

//같은 폴더안에 있으면 자동으로 선언안해줘도 됨

public class CustomerDemo {
	public static void main(String[] args) {
		
		Customer c1 = new Customer();
		c1.name = "c1's name";
		c1.email = "c1@email.com";
		System.out.println(c1.name + ", "+ c1.email);
		
		Customer c2 = new Customer();
		c2.name = "c2's name";
		c2.email = "c2@email.com";
		System.out.println(c2.name + ", "+ c2.email);
		
		Customer c3 = new Customer();
		c3.name = "c3's name";
		c3.email = "c3@email.com";
		System.out.println(c3.name + ", "+ c3.email);
		
		Customer c4 = c3;
		c4.name = "c4's name";
		System.out.println(c3.name + ", "+ c3.email);
		
		Customer c5 = new Customer();
		c5.name = "c2's name";
		c5.email = "c2@email.com";
		
		System.out.println(c2 == c5); //false
		System.out.println(c3 == c4); //
		
		
		//static variable은 어디서도 접근가능
		//그러나 클래스명에서 관리할수 있도록하는것이 관례
		//c1.interestRate = 10.2;
		//System.out.println(c3.interestRate);
		Customer.interestRate = 1.8;
		
		//final variable 은 수정 불가능임
		//Customer.BANKNAME = "anotherOne";
		
	}
}
