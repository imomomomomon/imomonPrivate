package bit.basic.variable;


public class VariableEx2 {
	public static void main(String[] args) {
		//Variable Example
		{
			ExampleVar e1 = new ExampleVar(1);
			ExampleVar e2 = new ExampleVar(2);
			
			e1.iInst +=1;
			e2.iInst +=1;
			e1.iStatic +=1;
			
			e1.printNum();
			System.out.println("-------------------------------");
			
			e2.iStatic +=1;
			
			e1.printNum();
			e2.printNum();
			System.out.println("-------------------------------");
		}
		
		{
			TypeCasting tc = new TypeCasting();
			tc.test();
		}
	}
}

class ExampleVar {
	public int iInst = 0;
	public static int iStatic = 0;
	
	private int iNum;
	
	ExampleVar(int num){
		iNum = num;
	}
	
	public void test() {
		printNum();
	}
	public void printNum() {
		int iLocal = 0;
		System.out.println("e"+ iNum +
				" iInst : " + iInst + " |  iStatic : " + iStatic + " | iLoacl : " + iLocal);
	}
}

class TypeCasting {
	public void test()
	{
		{
			int ia = Integer.MAX_VALUE; 
			System.out.println((long)(ia + 1));
			System.out.println((long)ia + 1);
			System.out.println((short)ia);
		}
		{
			char ca = 'A';
			byte ba = 65;
			System.out.println((int)ca);
			System.out.println((char)ca);
		}
	}
}
