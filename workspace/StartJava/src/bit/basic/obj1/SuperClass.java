package bit.basic.obj1;

public class SuperClass {
	private int superClassValue;
	
	public SuperClass() {
		super();
	}

	public int getSuperClassValue() {
		return superClassValue;
	}

	public void setSuperClassValue(int superClassValue) {
		this.superClassValue = superClassValue;
	}

	public SuperClass(int superClassValue) {
		super();
		this.superClassValue = superClassValue;
	}

	public void actionProcess() {
		System.out.println("actionProcess");
	}
}
