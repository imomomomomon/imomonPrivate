package bit.basic.obj5;

public class SuperInstanceMember {
	private int superValue;
	public void superValidate() {
		System.out.println("superValidate");
	}
	public class SuperInner {
		public int value = 100;
	}
}
