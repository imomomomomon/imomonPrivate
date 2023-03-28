package bit.basic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayEx4 {
	
	public double[] getValue(int ...x) {
		return new double[] {Math.sqrt(x[0]),Math.sqrt(x[1]),Math.sqrt(x[2])};
	}
	public void addValue(int []x) {
		System.out.println("1차원");
	} // 1차원
	public int addValue(int [][]x) {
		System.out.println("2차원");
		return x[0][0];
	} // 다차원
	public void arrayEx1() {
		int [][]m = new int[2][3];
		
		int []x = {1,2,3,4,5};
		int []y = {6,7,8};
		
		m[0] = x;
		m[1] = y;
	}
	public void arrayEx2() {
		ArrayList<Integer>i = new ArrayList<Integer>();
		
	}
	
	public static void main(String[] args) {
		ArrayEx4 a = new ArrayEx4();
		System.out.println(Arrays.toString(a.getValue(10,20,30)));
		for(double v:a.getValue(20,30,40))
			System.out.printf("%.2f ",v);
		System.out.println();
		a.addValue(new int[][] {{10,20},{30,40}});
		System.out.println();
		a.arrayEx1();
	}
}
