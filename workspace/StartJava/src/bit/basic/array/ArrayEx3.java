package bit.basic.array;

public class ArrayEx3 {
	public static void main(String[] args) {
		customArr arrC = new customArr();
		arrC.print();
	}
}

class customArr
{
	private int[] arrInt = new int[5];
	private int iCnt = 0;
	
	public void print() {
		
		for(int i = 0; i < 7; i++)
			push((int)(Math.random()*100));
		modify(3,100);
		delete();
		
		{
			for(int i = 0; i < arrInt.length; i++)
				System.out.printf("%4d",arrInt[i]);
		}
	}
	public void push(int data) {
		
		if(isFull())
			increment();
		
		arrInt[iCnt] = data;
		iCnt++;
	}
	
	public int search(int index) {
		
		if(isEmpty()) return 0;
		if(index > iCnt) return 0;
		
		return arrInt[index];
	}
	
	public boolean modify(int index, int data) {
		
		if(search(index) != 0)
		{
			arrInt[index] = data;
			return true;
		}
		
		return false;
	}
	
	public boolean delete() {
		if(isEmpty()) return false;
		
		iCnt--;
		arrInt[iCnt] = 0;
		
		return true;
	}
	
	public boolean delete(int index) {
		if(isEmpty()) return false;
		if(index >= iCnt) return false;
		
		for(int i = index; i <= iCnt; i++ )
			arrInt[i] = arrInt[i+1];
		arrInt[iCnt] = 0;
		iCnt--;
		
		return true;
	}
	
	public boolean isFull() {
		if(iCnt == arrInt.length - 1) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(iCnt == 0)
			return true;
		return false;
	}
	
	private void increment() {
		
		int[] temp = new int[arrInt.length * 2];
		
		System.arraycopy(arrInt, 0, temp, 0, arrInt.length);
		
		arrInt = temp;
	}
}
