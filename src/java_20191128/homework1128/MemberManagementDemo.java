package java_20191128.homework1128;

public class MemberManagementDemo {
	public void excute(MemberManagement m) {
		m.start();
	}
	
	public static void main(String[] args) {
		new MemberManagementDemo().excute(new MemberManagement());

	}
	
	
}
