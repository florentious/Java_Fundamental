package java_20191128;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		// HashMap : key값은 반드시 유일해야하고, value에는 데이터(객체)를 저장한다.
		// 데이터의 중복을 허용하며, key 값이 중복되는 경우엔 덮어쓰기를 한다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("1", 11111);
		map.put("2", 22222);
		map.put("3", 33333);
		map.put("4", 44444);
		map.put("5", 55555);
		map.put("1", 66666);
		
		Integer value = map.get("1");
		System.out.println(value);
		
		// map을 꺼내서 set에 저장하고 그를 Iterator로 전환해서 뽑아낸다.
		Set<String> set = map.keySet();
		
		Iterator<String> i = set.iterator();
		
		while(i.hasNext()) {
			String k = i.next();
			Integer v = map.get(k);
			System.out.format("key : %s, value : %d\n", k, v);
			//System.out.println(map.get(i.next()));
		}
		
		
		
	}
}


