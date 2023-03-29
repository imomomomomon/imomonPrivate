package bit.app.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Vector;

public class ExceptionEx1 extends Object{
	public void arithmeticException() {
//		System.out.println((int)(Math.random() * 100));
//		Random random = new Random();
//		int rs = random.nextInt(5);
//		System.out.println(rs);
		int []m = new int[5];
		for (int i = 0; i < m.length; i++) {
			try {
				m[i] = (int)Math.random()*100;
				int rs = 100 / m[i];
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				break;
			}
		}
	}
	public void NumberFormatException(String msg) {
		if (msg.startsWith("[STONE]")) {
			System.out.println("GAME ...");
			try {
				String []splitTemp = msg.substring(
						msg.indexOf(']')+1)
						.split(" ");
				int x = Integer.parseInt(splitTemp[0].split("=")[1]);
				int y = Integer.parseInt(splitTemp[1].split("=")[1]);
				int z = Integer.parseInt(splitTemp[2].split("=")[1]);
				System.out.println("x/y/z="+x+"/"+y+"/"+z);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} 
		if (msg.startsWith("[ROOM]")) {
			System.out.println("ROOM ...");
		}
	}
	public void arrayIndexOutOfBoundsException() {
		int []m = new int[5];
		for (int i = 0; i <= m.length; i++) {
			try {
				System.out.println("TryStartLine");
				m[i] = 100;
				System.out.println("Data="+m[i]);
				System.out.println("TryEndLine");
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				//e.printStackTrace();
				System.out.println(e.getMessage());
			} finally {
				System.out.println("finally");
			}
		}
	}
	public void cloneNotSupportedException() {
		Vector<String> v = new Vector<String>();
		v.add("딸기");
		v.add("수박");
		System.out.println(v.clone());
	}
	public void noSuchElementException() {
		ArrayList<Integer>list1 = new ArrayList<Integer>();//LIST
		HashSet<Integer>hs = new HashSet<Integer>();//SET
		
		list1.add(10);
		list1.add(43);
		list1.add(30);
		
		hs.add(45);
		hs.add(345);
		hs.add(125);
		hs.add(78);
		hs.add(78);
		
		for (Iterator iterator = list1.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		
		for (Iterator iterator = hs.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		for(Integer i :list1) {
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		ExceptionEx1 e = new ExceptionEx1();
//		e.arrayIndexOutOfBoundsException();
//		e.arithmeticException();
//		e.NumberFormatException("[STONE]x=150 y=300 z=500");
//		e.NumberFormatException("[ROOM]안녕하세요");
//		e.cloneNotSupportedException();
		e.noSuchElementException();
	}
}
