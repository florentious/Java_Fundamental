package java_20191128.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;
	
	// construcotr
	public MemberManagementDemo() {
		super();
		list = new ArrayList<Member>();
	}
	
	public void print() {
		System.out.println("**********************************************************");
		System.out.println("****  1)Insert  2)Update  3)Delete  4)Search  5)Exit  ****");
		System.out.println("**********************************************************");
		
	}
	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public void run(String index) {
		if(index.equals("1")) {
			//insert
			insert();
		}else if(index.equals("2")) {
			//update
		}else if(index.equals("3")) {
			//delete
		}else if(index.equals("4")) {
			//search
		}else if(index.equals("5")) {
			//exit
			System.out.println("Thanks for using this Program");
		}else {
			//exit
			System.out.println("사요나라");
			
		}
		
		
	}
	
	// insert
	// 1. 아이디를 입력받는다.
	// 2. 이름을 입력받는다.
	// 3. ArrayList에 멤버를 추가한다.
	// 4. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 5. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	public void insert() {
		// requirement 1,2
		String id = console("ID> ");
		String name = console("Name> ");
		
		// requirement 3
		// 회원 이름을 확인하여 같으면 재입력해달라고 요구한다. 아이디가 유일무이하게 만든다.
		Member temp = new Member(id,name);
		list.add(temp);
		
		//추가된 명단을 확인한다.
		System.out.printf("총 회원은 %d명 입니다.\n",list.size());
				
		// requirement 4,5
		print();
		String index = console("번호를 선택하세요> ");
		run(index);
	}
	
	// update
	// 1. 수정할 아이디를 입력받는다.
	// 2. id를가지고 ArrayList에 있는 멤버중에 수정할 아이디를 찾아서 있으면 수정할 이름을 입력받고, ArrayList에 멤버정보를 수정한다.
	//    만약 없으면 "수정할 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. ArrayList에 있는 멤버정보를 모두 출력한다.
	// 4. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 5. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	public void update() {
		String id = console("input id> ");
		
		for(int i=0;i<list.size();i++) {
			if(id == list.get(i).getId()) {
				String name = console("input name> ");
				list.get(i).setName(name);
			}
		}
		
		
	}
	
	// delete
	// 1. 삭제할 아이디를 입력받는다.
	// 2. id를가지고 ArrayList에 있는 멤버중에 수정할 아이디를 찾아서 있으면 멤버정보를 삭제한다.
	//    만약 없으면 "삭제할 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. ArrayList에 있는 멤버정보를 모두 출력한다.		- 삭제 확인용
	// 4. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 5. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 6. 번호를 입력받으면 run() 메서드를 호출한다.
	public void delete() {
		
	}
	
	// search
	// 1. 검색할 아이디를 입력받는다.
	// 2. id를가지고 ArrayList에 있는 멤버중에 검색할 아이디를 찾아서 있으면 멤버정보를 출력하고
	//    만약 없으면 "검색 된 아이디가 없습니다." 라는 메세지를 출력한다.
	// 3. print() 메서드를 호출하여 번호를 재 선택하게 한다.
	// 4. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	// 5. 번호를 입력받으면 run() 메서드를 호출한다.
	public void search() {
		
	}
	
	public void check() {
		
	}
	
	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		m1.print();
		String index = m1.console("번호를 선택하세요 > ");
		m1.run(index);
	}
	
	
}
