package java_20191122.aa;

public class Notice {
	public int number;
	protected String title;
	int hit;
	private String regdate;
	
	public void method1() {
		
	}
	
	public void method2() {
		
	}
	
	public static void main(String[] args) {
		Notice n = new Notice();
		// 가장 공유범위가 적은 private도 이용가능
		n.number = 10;
		n.title = "title";
		n.hit = 100;
		n.regdate = "2019-11-22";
	}
}
