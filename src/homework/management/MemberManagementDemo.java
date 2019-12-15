package homework.management;

public class MemberManagementDemo {
	public void run() {
		MemberManagement.getInstance().start();
	}
	
	public static void main(String[] args) {
		new MemberManagementDemo().run();
	}
}
