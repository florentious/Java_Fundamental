package java_20191126;

public class ChildDemo {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.age = 55;
		p1.playBaddok();
		p1.work();
		
		Child c1 = new Child();
		c1.age = 25;
		c1.height = 155.24;
		c1.playBaddok();
		c1.playGame();
		c1.work();
		
		Parent p2 = new Child();
		p2.age = 60;
		//p2.height = 155.24;
		p2.playBaddok();
		//p2.playGame();
		p2.work();				//Sub-Class의 work가 호출됨

		//Child c2 = (Child) new Parent();	//주소 오브젝트를 찾아낼수 없음;
		
		
	}
}
