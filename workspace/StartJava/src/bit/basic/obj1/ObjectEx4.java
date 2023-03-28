package bit.basic.obj1;

import java.io.*;
import java.util.*;

public class ObjectEx4 {
	
	public static void main(String[] args) {
		ObjectEx4 o = new ObjectEx4();
//		o.methodObj1();
		o.methodObj2("");
		
		ObjectEx4.InnerClass inner = o.new InnerClass();
		System.out.println(inner.value);
	}
	
	public InputStream getBufferInput() throws FileNotFoundException {
		return new FileInputStream(new File(""));
	}
	public List getList() {
		return new Stack();
	}

	private void methodObj1() {
		// TODO Auto-generated method stub
		System.out.println("Data:");
		BufferedReader br = null;
		BufferedInputStream bis = null;
		try {
//			bis = new BufferedInputStream(
//					new FileInputStream(
//						new File(
//							new StringBuffer().toString())));
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(br.readLine());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void methodObj2(String value) {
		
	}
	
	class InnerClass {
		int value;
	}
}
