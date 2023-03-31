package bit.basic.collection;

import java.util.HashSet;
import java.util.Iterator;

//일종의 주머니
//대소문자 구분함
public class SetEx1 {
	public void setProcess1() {
		String []lesson = {"Java","DataBase","Servlet","Spring","Css",
				"Java","Css"};
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		for (int i = 0; i < lesson.length; i++) {
			if(!hs1.add(lesson[i]))
				hs2.add(lesson[i]);
		}
		
		for(String item:hs1) {
			System.out.println(item);
		}
		System.out.println();
		Iterator<String> itor = hs2.iterator();
		while (itor.hasNext()) {
			System.out.println((String) itor.next());
		}
		System.out.println();
		
		@SuppressWarnings("unchecked")
		HashSet<String> hs3 = (HashSet<String>)(hs1.clone());
		hs3.clear();
		hs1.remove("Java");
		
		System.out.println(hs3);
		System.out.println(hs1);
		System.out.println(hs2);
		System.out.println(hs2.contains("java"));
		
	}
	public static void main(String[] args) {
		SetEx1 s = new SetEx1();
		s.setProcess1();
	}
}
