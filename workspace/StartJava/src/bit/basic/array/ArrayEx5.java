package bit.basic.array;

import java.util.Arrays;

//최댓값, 최솟값, 근사값, 편차, 최빈값, 합계, 평균, 개수, 평균이상갯수, 평균이하갯수

public class ArrayEx5 {
	private int []m = new int[10];
	ArrayEx5() {
		
		for (int i = 0; i < m.length; i++) {
			m[i] = (int)(Math.random()*100);
		}
	}
	public void print() {
		for (int i = 0; i < m.length; i++) {
			System.out.printf("%4d",m[i]);
		}
		System.out.println();
		
		System.out.println("평균값:"+averageValue());
		System.out.println("편차값:"+Arrays.toString(deviationValue()));
		System.out.println("최댓값:"+ maxValue(1));
		System.out.println("최솟값:"+ minValue(1));
		System.out.println("평균근사값:"+approxValue(averageValue()));
		System.out.println("최빈값:"+modeValue());
		System.out.println("평균이상갯수:"+averageMore());
		System.out.println("평균이하갯수:"+averageBelow());
	}
	public int maxValue(int order) {
		sorting_selection(0);
		return m[order-1];
	}
	public int minValue(int order) {
		sorting_selection(1);
		return m[order-1];
	}
	public int approxValue(int data) {
		sorting_selection(0);
		int temp = data;
		int index = 0;
		
		for(int i = 0; i < m.length; i++)
		{
			int abs = Math.abs(data - m[i]);
			if(temp > abs)
			{
				temp = abs;
				index = i;
			}
		}
		
		return m[index]; 
	}
	public int sumValue() {
		int sum = 0;
		for (int i = 0; i < m.length; i++)
			sum += m[i];
		return sum;
	}
	public int averageValue() {
		return sumValue() / m.length;
	}
	public int[] deviationValue() {
		int[] arrMinus = new int[m.length];
		int average = averageValue();
		for (int i = 0; i < m.length; i++) {
			arrMinus[i] = m[i] - average;
		}
		
		return arrMinus;
	}
	public String modeValue() {
		
		int []index = new int[m.length];
		{//중복을 제외한 배열재생성
			int cnt = 0;
			
			for (int i = 0; i < m.length; i++) {
				int temp = m[i];
				int j = 0;
				while (true) {
					if(j == m.length) break;
					if(index[j] == temp) break;
					if(index[j] == 0)
					{
						index[cnt] = m[i];
						cnt++;
						break;
					}
					j++;
				}
			}
		}
		
		int []count = new int[index.length];
		int max = 0;
		{//배열 2개 비교로 각 원소마다 중복원소 체크
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < index.length; j++) {
					if(m[i] == index[j]) {
						count[j]++;
						if(count[j] > max) max = count[j];
						break;
					}
				}
			}
		}
		
		if(max == 1) return "중복값 없음";
		String result = "";
		{//최빈값 출력
			for (int i = 0; i < count.length; i++) {
				if(max == count[i])
				{
					for (int j = 0; j < max; j++)
						result += Integer.toString(index[i]) + " ";
				}
			}
		}
		
		return result;
	}
	public int averageMore() {
		int cnt = 0;
		int average = averageValue();
		for (int i = 0; i < m.length; i++) {
			if(average >= m[i])
				cnt++;
		}
		
		return cnt;
	}
	public int averageBelow() {
		int cnt = 0;
		int average = averageValue();
		for (int i = 0; i < m.length; i++) {
			if(average <= m[i])
				cnt++;
		}
		
		return cnt;
	}
	public void swap(int i, int j)
	{
		int temp = 0;
		temp = m[i];
		m[i] = m[j];
		m[j] = temp;
	}
	public void sorting_selection(int order) {
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = i+1; j < m.length; j++) {
				if(order ==0) { //내림차순
					if(m[i] < m[j]) {
						swap(i,j);
					}
				} else {
					if(m[i] > m[j]) { //오름차순
						swap(i,j);
					}
				}
			}
		}
	}
	public void sorting_Quick(int[] arr,int left, int right) {
		if(left > right)
			return;
		int pivot = partition(arr,left,right); // 피벗을 기준으로 재배열
		
		sorting_Quick(arr, left, pivot - 1);
		sorting_Quick(arr, pivot +1, right);
	}
	public int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left;
		int j = right;
		
		while (left < right) {
			
		}
		
		return 0;
	}
	public static void main(String[] args) {
		ArrayEx5 a = new ArrayEx5();
		a.print();
	}
}
