package CollectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>(); //Map<불변객체>
		
		String ks1 = "one";
		
		map.put(ks1, 1); //auto boxing
		map.put("two", 2);
		map.put("three", 3);
		
		int i = map.get(ks1); //auto unboxing
		int j = map.get(new String("one")); //해쉬코드랑 이퀄즈가 오버라이딩 안되어있으면 같은객체 아니면 다른 객체
		System.out.println(i + " " + j);
		
		map.put("three", 33333);		
		System.out.println(map.get("three"));
		
		//순회
		Set<String> s = map.keySet();
		for(String key : s) {
			int val = map.get(key);
			System.out.println(val);
		}
	}
}
