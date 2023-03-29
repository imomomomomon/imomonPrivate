package bit.pk.app1;

public class Sub extends Super{
	public Sub() {
		this.publicData = 10;
		this.protectedData = 20;
		this.defaultData = 30;
		//this.privateData = 40;
		//접근불가 -> Super의 Class 안에서만
		//priavteData로 접근가능
	}
}
