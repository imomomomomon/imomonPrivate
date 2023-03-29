package Practice;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int []arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100);
		}
		System.out.println("힙소트 전 : "+Arrays.toString(arr));
		new HeapSort().sort(arr,1);
		System.out.println("힙소트 후 : "+Arrays.toString(arr));
	}
	
	public void sort(int []arr,int order) {
		
		//최대 힙(MAXHeap) 구조로 배열 삽입
		for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
			heapfiy(arr,arr.length,i,order);
		}
		
		//끝값부터 뒤로 밀면서 정렬
		for (int i = arr.length - 1; i > 0 ; i--) {
			swap(arr,0 ,i);//끝자리와 첫자리를 변경
			heapfiy(arr,i,0,order);//마지막 자리를 제외하고 다시 힙구현
		}
	}
	
	private void heapfiy(int []arr, int length, int index, int order) {
		int parent = index;
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		
		if(left < length && 
				compareSwitch(arr[parent],arr[left],order))
			parent = left; // 왼쪽 자식이 부모보다 클경우
		if(right < length && 
				compareSwitch(arr[parent],arr[right],order)) 
			parent = right; //오른쪽 자식이 부모다 클 경우
		if(index != parent) {//부모의 값이 변경되었다면?
			swap(arr,parent,index); // 변경된 자식과 부모의 값을 변경
			heapfiy(arr,length,parent,order); // 변경된 포지션으로 다시 힙구성
		}
	}
	
	private boolean compareSwitch(int target, int compare,int order) {
		if(order == 0)
		{
			if(target < compare)
				return true;
		} else {
			if(target > compare)
				return true;
		}
		return false;
	}
	
	private void swap(int []arr, int target, int change) {
		int temp = arr[target];
		arr[target] = arr[change];
		arr[change] = temp;
	}
}