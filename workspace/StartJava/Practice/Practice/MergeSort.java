package Practice;

import java.util.Arrays;

public class MergeSort {
	
	void sort(int []arr, int left, int right)
	{
		if(left == right) return;
		
		int middle = (left + right) / 2;
		sort(arr, left, middle);
		sort(arr, right, middle);
		merge(arr);
	}
	void merge(int []arr) {
		
	}
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int []arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		ms.sort(null, 0, 0);
	}
}
