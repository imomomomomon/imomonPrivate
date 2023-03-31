package bit.basic.collection;

import java.util.*;

public class ListEx2 {
	public void listProcess1() {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("지현");
		list1.add("진근");
		list1.add("진근2");
		list1.add("진근3");
		System.out.println(list1.toString());
		
		Iterator<String> itor =  list1.iterator();
		list1.remove(0);
		itor.next();
		
	}
	public static void main(String[] args) {
		ListEx2 list = new ListEx2();
		list.listProcess1();
	}
}
