package java_20191128.homework1128;

public class Member extends Object{
	private String id;
	private String name;
	
	//constructor
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//getter, setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "회원 [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
