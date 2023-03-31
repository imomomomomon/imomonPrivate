package bit.test.demo;

public class ActionTest2 {
	private InstanceClass inst;
	
	public static void main(String[] args) {
		ActionTest2 ex = new ActionTest2();
		ex.action();
	}
	
	public void action() {
		StaticClass.getInst().print();
		
		inst = new InstanceClass();
		inst.print();
	}
}

class StaticClass {
	private StaticClass() {}
	private static StaticClass inst;
	public static StaticClass getInst() {
		if(inst == null)
			inst = new StaticClass();
		return inst;
	}
	public void print() {
		System.out.println("Static Class");
	}
}

class InstanceClass {
	public void print() {
		System.out.println("instance Class");
	}
}