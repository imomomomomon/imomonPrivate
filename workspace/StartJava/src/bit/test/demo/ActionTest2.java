package bit.test.demo;

import java.util.Arrays;

public class ActionTest2 {
	public static void main(String[] args) {
		 int arr[] = {23,54,52,1,2,84,57,4};
		 
		 ActionTest2 ex = new ActionTest2();
		 ex.sort(arr);
		 System.out.println(Arrays.toString(arr));
	}
	
	public void sort(int []arr) {
		int min = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			min = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[min])
					min = j;
			}
			if(min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
}