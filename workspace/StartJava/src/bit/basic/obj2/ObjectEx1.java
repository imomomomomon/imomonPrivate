package bit.basic.obj2;

public class ObjectEx1 {
	private final static int CNT;
	static {
		CNT = 90;
	}
	public ObjectEx1() {
		
	}
	public static void main(String[] args) {
		System.out.println(ObjectEx1.CNT);
		System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		ObjectEx1 o = new ObjectEx1();//cnt
	}
}
