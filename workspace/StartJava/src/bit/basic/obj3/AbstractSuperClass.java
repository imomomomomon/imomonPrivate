package bit.basic.obj3;

//추상클래스에는 final을 쓸 수 없다
//확장을 위한 추상클래스에 final를 붙이는 것은 확장을 막는것.
public abstract class AbstractSuperClass {
	public AbstractSuperClass() {
		// TODO Auto-generated constructor stub
		System.out.println("AbstractSuperClass");
	}
	public void abstrackSuperMethod() {
		System.out.println("abstrackSuperMethod");
	}
	public abstract void abstractMethodSP(); // 미완성
}
