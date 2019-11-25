package java_20191122.aa;

// 클래스의 접근한정자는 다른 패키지에서 접근가능함
// 접근한정자는 선언할때 접근가능한지 확인함
public class NoticeDemo {
	public static void main(String[] args) {
		Notice n = new Notice();
		// 가장 공유범위가 적은 private도 이용가능
		n.number = 10;
		n.title = "title";
		n.hit = 100;
		// n.regdate = "2019-11-22"; //private라 같은 클래스 밖에 있기 때문에 접근이 안됨 
	}
}
