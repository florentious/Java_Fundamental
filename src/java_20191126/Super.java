package java_20191126;

public class Super extends Object{								//extends Object
	int money;
	
	public Super() {
		super();
	}

	public Super(int money) {
		super();					//모든 생성자에는 super(); 가 숨어있다.
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void makeMoney() {
		System.out.println("SUper makeMoney()");
	}
	
	public void play(String omok) {
		System.out.println("Super play()" + omok); 
	}
	
}
