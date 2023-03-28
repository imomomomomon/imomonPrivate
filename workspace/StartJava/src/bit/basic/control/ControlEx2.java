package bit.basic.control;

public class ControlEx2 {
	
	private void testingIfElse()
	{
		int num1 = 0;
		int num2 = 0;
		//num1
		{
			if(num1 == 0) {
				num1++;
			} if(num1 == 1) {
				num1++;
			}
		}
		//num2
		{
			if(num2 == 0) {
				num2++;
			} else if(num2 == 2) {
				num2++;
			}
		}
		
		System.out.println("num1 = "+num1+"| num2 = "+ num2);
	}

	private void testingWhile(){
		int num1 = 0;
		int num2 = 0;
		
		//num1
		{
			while (num1 < 0) {
				num1++;
			}
		}
		//num2
		{
			do {
				num2++;
			} while (num2 < 0);
		}
		
		System.out.println("num1 = "+num1+"| num2 = "+ num2);
	}
	
	public static void main(String[] args) {
		ControlEx2 ex = new ControlEx2();
		ex.testingIfElse();
		ex.testingWhile();
	}
}
