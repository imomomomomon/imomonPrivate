package bit.basic.array;

import java.util.Arrays;

public class ArrayEx2 {
	public void methodArray1(int[] x) {
		int[] temp = {55,65,75,85};
		x = temp;
	}
	public static void main(String[] args) {
		ArrayEx2 a = new ArrayEx2();
		
		int[] x = {10,20,30,40};
		a.methodArray1(x);
		System.out.println(Arrays.toString(x));
	}
}
