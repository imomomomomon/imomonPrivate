package bit.basic.array;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayEx1 {
	
	public void arrayMethod() {
		int[] m = new int[5];
		
		for (int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*100);
		}
		
		System.out.println(Arrays.toString(m));
		
		for (int i = 0; i < m.length; i++) {
			System.out.printf("%5d",m[i]);
		}
		
		System.out.println();
		for(int i:m){
			System.out.printf("%1d",i);
		}

	}
	
	public void arrayMethod2() {
		int[][] matrix = {{10,20,30},{40,50,60,70,80},{90,91}};
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%4d",matrix[i][j]);
			}
			System.out.println();
		}
		
		for(int[] i:matrix) {
			for(int j:i) {
				System.out.printf("%4d",j);
			}
			System.out.println();
		}
		
		for(int[] i:matrix) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	public static void main(String[] args) {
		ArrayEx1 a = new ArrayEx1();
//		a.arrayMethod();
		a.arrayMethod2();
		
  
	}
}