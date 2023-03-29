package bit.basic.obj5;

//MemberInner,StaticInner,LocalInner, AnoymousInner
public class OutterClass {
	
	public static void main(String[] args) {
		OutterClass outter = new OutterClass();
		OutterClass.Inner inner = new OutterClass().new Inner();
		inner.innerMethod();
		
		
		
		AnoymousInterface first = new AnoymousInterface() {
			public void Print() {
				System.out.println("First");
			}
		};
		
		first.Print();
	}
	
	private int outterValue;//Instance Variable(Member Instance)
	private int x;
	public OutterClass() {
		
		System.out.println("outterClass");
		
	}
	public void outterMethod() {
		System.out.println("outterMethod");
		System.out.println("out="+x);
		System.out.println("outterValue="+outterValue);
	}
	public class Inner {//Friend 개념, 접근제한자에 상관없이 관계를 맺음 ->MemberInner
		private int innerValue;
		private int x;
		public Inner() {
			System.out.println("Inner()");
		}
		public void innerMethod() {
			outterValue = 90;
			OutterClass.this.outterValue = 60;
			OutterClass.this.x = 70;
			this.x = 120;
			outterMethod();
		}
	}
}

interface AnoymousInterface {
	public void Print();
}