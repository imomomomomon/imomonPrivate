package bit.basic.obj1;

public class SuperMain {
	public static void main(String[] args) {
//		SuperClass[] classes = new SuperClass[3];
//		{
//			classes[0] = new SubClass01();
//			classes[1] = new SubClass02();
//			classes[2] = new SubClass03();
//		}
		
		SuperClass s1 = new SubClass01(10,20);
		s1.actionProcess();
		((SubClass01)(s1)).actionSub();
	}
}
