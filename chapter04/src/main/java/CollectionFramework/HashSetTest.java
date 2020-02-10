package CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("또치");
		String s2  = new String("또치");
		String s3 = new String("또치");
		
		System.out.println(s1 == s2);
		
		s.add("둘리");
		s.add("마이콜");
		s.add(s1);
		
		System.out.println(s.contains(s2)); //contains는 동질성 비교 동일성x 내용으로 비교하는 것 중요..
		System.out.println(s.size());
		
		//순회
		Iterator<String> it = s.iterator(); //collection에 있는 iterator
		while(it.hasNext())
		{
			String str = it.next();
			System.out.println(str);
		}
	}

}
