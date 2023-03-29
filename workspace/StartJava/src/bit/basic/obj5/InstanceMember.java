package bit.basic.obj5;
//MemeberInner
public class InstanceMember extends SuperInstanceMember{
	public static void main(String[] args) {
		InstanceMember.Inner inner = new InstanceMember().new Inner();
		
	}
	//Variable
	private int x;
	
	//Method
	public InstanceMember() {
		this.superValidate();
		SuperInstanceMember.SuperInner sIn =
				new SuperInstanceMember.SuperInner();
	}
	public void outterMemeberMethod() {
		System.out.println("x="+x);
	}
	public class Inner {
		public Inner() {
			InstanceMember.this.x = 100;
			InstanceMember.this.superValidate();
		}
	}//inner
}//outter
