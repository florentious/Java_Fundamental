package java_20191122.bb;

// 서로다른 패키지의 클래스를 사용하기 위해서는 반드시 import 해줘야한다.
import java_20191122.aa.Notice;


public class NoticeDemo2 extends Notice {
	public static void main(String[] args) {
		Notice n = new Notice();
		// 가장 공유범위가 적은 private도 이용가능
		n.number = 10;
		//n.title = "title";
		//n.hit = 100;
		//n.regdate = "2019-11-22";
		
		// 본인은 안되고 상속받은애만 가능한것 
		//Notice 클래스를 상속받은 noticeDemo2 클래스로 객체를 생성한 경우에만 protected 접근이 가능함
		// 본인은 안됨
		NoticeDemo2 nc = new NoticeDemo2();
		nc.number = 10;
		nc.title = "title";
		
	}
}
