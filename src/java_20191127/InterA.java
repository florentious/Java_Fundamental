package java_20191127;

public interface InterA extends InterB, InterC{
	// interface identifier 선언시  public static final 이 생략가능
	double PI = 3.14;
	// interface의 접근 한정자를 붙이지 않으면 public 
	// abstract 생략가능
	void mA();		// public abstract void mA();
	
}
