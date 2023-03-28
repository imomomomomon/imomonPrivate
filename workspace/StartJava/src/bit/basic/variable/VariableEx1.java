package bit.basic.variable;
	/*
	 * Variable Scope(변수 영역)
	 * local -> Stack 지역, 
	 * instance -> Heap 지역, 
	 * static -> Method(static, class) 지역
	 * 
	 * Class(설계도(속성+기능)) -> Object(객체) 생성
	 * Object(데이터 - 기능을 갖춘)
	 * 
	 * 변수 - Primitive(기본) | Reference(참조)
	*/
public class VariableEx1 {
	int y; // heap
	static int z;
	public void variableMethod1() {
		int x; // 지역변수 stack
	}
	public static void main(String[] args) {
		char a = 'a';
		System.out.println((int)a);
	}
}
