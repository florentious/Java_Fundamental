package java_20191128;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		//HashSet 데이터(객체)의 중복을 허용하지 않고, 순서가없음
		//HashSet<Integer> set = new HashSet<Integer>();
		Set<Integer> set = new TreeSet<Integer>();			//TreeSet은 데이터 객체의 중복을 허용하지 않고, 출력시 오름차순으로 정렬된다.
		
		while(true) {								// equals로 판단해서 같은건 쳐낸다
			int random = (int)(Math.random()*45) + 1;
			set.add(random);
			if(set.size()==6) {
				break;
			}
		}
		
		
		Iterator<Integer> i = set.iterator();
		
		while(i.hasNext()) {						// hasNext() : HashSet에 출력할 객체가 존재하느닞 판단하는 메서드
			int temp =  i.next();					// next() : 해당객체를 가져온다
			System.out.print(temp + "\t");
		}
		System.out.println();
		
		
		HashSet<Test> s = new HashSet<Test>();
		s.add(new Test(10));
		s.add(new Test(20));
		s.add(new Test(10));
		
		System.out.println(s.size());
		
		
		
		
	}
}


class Test {
	int a;
	
	Test(int a) {
		this.a = a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (a != other.a)
			return false;
		return true;
	}
	
}
