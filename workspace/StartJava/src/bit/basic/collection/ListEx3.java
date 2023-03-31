package bit.basic.collection;

import java.util.*;

public class ListEx3 {
	public void listEx1() {
		Vector<Integer> vec= new Vector<Integer>();
		int []value = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < value.length; i++)
			vec.add(i,value[i]);
		System.out.println(vec.toString());
		
		Iterator<Integer> itor = vec.iterator();
		for(;itor.hasNext();)
			System.out.printf("%3d",itor.next());
		
		System.out.println();
		Enumeration<Integer> e = vec.elements();
		while (e.hasMoreElements()) {
			System.out.printf("%3d",e.nextElement());
		}
		
		System.out.println();
		StringTokenizer st = new StringTokenizer("java oracle mySQL Servlet");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement().toString());
		}
	}
	public void listEx2() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(10);
		stack.add(20);
		stack.add(30);
		stack.add(40);
		stack.add(10);
		System.out.println(stack.toString());
		System.out.print(stack.search(10));
	}
	
	public static void main(String[] args) {
		ListEx3 list = new ListEx3();
		list.listEx2();
	}
}
