package bit.basic.array;

import java.util.Arrays;

public class MatrixEx1 {
	public static void main(String[] args) {
		
		CustomMatrix cm = new CustomMatrix(2,4);
		
		for(int i = 0; i < 10; i++) {
			int temp = (int)(Math.random() * 100);
			if(temp == 0) temp = 1;
			cm.push(temp);
		}
		System.out.println("-Push 10번-");
		cm.print();
		
		System.out.println("-Pop 3번-");
		for(int i = 0; i < 3; i++) {
			cm.pop();
		}
		cm.print();
		System.out.println("-(0,3)에 999 추가=");
		cm.insert(0,3,999);
		cm.print();
		System.out.println("-(0,0) 삭제-");
		cm.delete(0, 0);
		cm.print();
	}
}

//데이터 입력할때 메모리 공간 부족시
//새로운 row열 생성
//값은 0이외의 정수를 입력
class CustomMatrix {
	private int [][]matrix;
	public int index_row;
	public int index_col;
	
	public CustomMatrix(int row, int col) {
		matrix = new int[row][col];
		index_row = 0;
		index_col = -1;
	}
	
	public void print() {
		for(int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
	
	public void push(int value) {
		checkMemoryLimit(index_row);
		
		index_col++;
		if(index_col == matrix[index_row].length) {
			index_col = 0;
			index_row++;
		}
		matrix[index_row][index_col] = value;
	}
	
	public void pop() {
		if(matrix[0][0] == 0) return;

		matrix[index_row][index_col] = 0;		
		if(index_col == 0) {
			if(index_row != 0) {
				index_row--;
				index_col = matrix[index_row].length - 1;
				return;
			}
		}
		index_col--;
	}
	
	public int search(int row, int col) {
		return matrix[row][col];
	}
	
	public int[] search(int value) {
		int[] result = new int[2];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == value) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return null;
	}
	
	public void modify(int row, int col, int value) {
		matrix[row][col] = value;
	}
	
	public void modify(int data, int value) {
		int []point = search(data);
		matrix[point[0]][point[1]] = value;
	}
	
	public void delete(int row, int col) {
		int []point = {row,col};
		
		matrix[point[0]][point[1]] = 0;
		if(point[0] == matrix.length -1 && 
				point[1] == matrix[row].length - 1) return;
		
		int []nextpoint = {point[0], point[1]+1};
		if(nextpoint[1] == matrix[row].length) {
			nextpoint[0]++;
			nextpoint[1] = 0;
		}
		
		while(true) {
			matrix[point[0]][point[1]] = matrix[nextpoint[0]][nextpoint[1]]; 
			
			point[0] = nextpoint[0];
			point[1] = nextpoint[1];
			
			nextpoint[1]++;
			if(nextpoint[1] == matrix[row].length) {
				nextpoint[0]++;
				nextpoint[1] = 0;
			}
			
			if(matrix[point[0]][point[1]] == 0) break;
		}
	}
	
	public void insert(int row, int col, int value) {
		if(matrix[row][col] == 0) return;
		
		int []point = {row,col};
		int []nextpoint = {point[0], point[1]+1};
		if(nextpoint[1] == matrix[row].length) {
			nextpoint[0]++;
			nextpoint[1] = 0;
		}
		int cur = value;
		int next = matrix[point[0]][point[1]];
		while(true) {
			{	//값 밀기
				int temp = 0;
				
				matrix[point[0]][point[1]] = cur;
				cur = next;
				temp = matrix[nextpoint[0]][nextpoint[1]];
				matrix[nextpoint[0]][nextpoint[1]] = cur;
				next = temp;
			}
			{	//주소 전진
				point[0] = nextpoint[0];
				point[1] = nextpoint[1];
				
				nextpoint[1]++;
				if(nextpoint[1] == matrix[row].length) {
					nextpoint[0]++;
					nextpoint[1] = 0;
				}
			}
			if(matrix[point[0]][point[1]] == 0) break;
		}
	}
	
	private void checkMemoryLimit(int row) {
		if(isRowFull(row)) {
			if(row == matrix.length - 1)
				increment();
			else
				checkMemoryLimit(row+1);
		}
	}
	
	private boolean isRowFull(int row) {
		for(int i = 0; i < matrix[row].length; i++) {
			if(matrix[row][i] == 0) return false;
		}
		return true;
	}
	
	private void increment() {
		int [][]temp = new int[matrix.length+1][];
		for(int i = 0; i < matrix.length; i++)
			temp[i] = matrix[i];
		temp[matrix.length] = new int[matrix[0].length];
		matrix = temp;
	}
}
