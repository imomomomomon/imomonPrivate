package bit.basic.obj1;

public class SubClass01 extends SuperClass {
	private int subClass1Value;
	public SubClass01() {
		super();
	}
	
	public int getSubClass1Value() {
		return subClass1Value;
	}

	public void setSubClass1Value(int subClass1Value) {
		this.subClass1Value = subClass1Value;
	}

	public SubClass01(int subClass1Value) {
		super();
		this.subClass1Value = subClass1Value;
	}
	public SubClass01(int superClass1Value, int subClass1Value) {
		super(superClass1Value);
		this.subClass1Value = subClass1Value;
	}
	
	@Override
	public void actionProcess() {
		// TODO Auto-generated method stub
		System.out.println("SubClass01");
	}
	
	public void actionSub() {
		System.out.println("actionSub1");
	}
	
}
