package bit.basic.obj3;

//완전 추상클래스
public interface InterfaceEx1 {
	public static final int data = 100;
	public void showInterEx1();
	public default void showDefault() {
		System.out.println("Default_InterfaceEx1");
	}
}
