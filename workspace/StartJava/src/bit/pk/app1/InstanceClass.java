package bit.pk.app1;

public class InstanceClass {
	public static void main(String[] args) {
		Sub sb = new Sub();
		
		System.out.println("Super.publicdata : "+ sb.publicData);
		System.out.println("Super.protectedData : "+ sb.protectedData);
		System.out.println("Super.defaultData : "+ sb.defaultData);
		//System.out.println("Super.privateData : "+ sb.privateData);
		//접근불가 -> private는 Super의 class안에서만 접근가능
	}
}
