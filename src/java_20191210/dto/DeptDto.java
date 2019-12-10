package java_20191210.dto;

public class DeptDto {
	// class에 대한 이름에 대한 명명시 클래스 이름과 중복이 되지 않게 한다.
	// member variable encapsulation
	private int no;
	private String name;
	private String loc;
	
	public DeptDto() {
		super();
	}
	public DeptDto(int no, String name, String loc) {
		super();
		this.no = no;
		this.name = name;
		this.loc = loc;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	
	
}
