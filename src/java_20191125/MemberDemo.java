package java_20191125;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();
		//getter, setter
		m.setName("man");
		m.setZipcode("1234");
		m.setAddress1("서울");
		m.setAddress2("위치");
		
		System.out.println(m.getName());
		System.out.println(m.getZipcode());
		System.out.println(m.getAddress1());
		System.out.println(m.getAddress2());
	}
}
