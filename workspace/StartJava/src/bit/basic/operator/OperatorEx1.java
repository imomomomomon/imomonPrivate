package bit.basic.operator;

/*
 * 최 우선 () .(닷지) [](블릿)
 * 단 항연산자
 * 논 리연산자
 */

public class OperatorEx1 {
	/*
	public int FirstOperator(int ix, int iy, int iz, int ik) {
		return ix > iy ? (ix+iy*iz+ik):(ix+iy)*iz+ik; 
	}*/
	public int FirstOperator(int ...ix) {
		return ix[0];
	}
	public void logicMethod(int x, int y, int z) {
		boolean b = ++x == 1 & y++==2;
		System.out.println("B = "+b+" x="+x);
	}
	public static void main(String[] args) {
		OperatorEx1 o1 = new OperatorEx1();
		System.out.println(o1.FirstOperator(1,2,3,4,5));
		o1.logicMethod(0, 0, 0);
	}
}
