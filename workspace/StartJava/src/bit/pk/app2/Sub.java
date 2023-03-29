package bit.pk.app2;

import bit.pk.app1.Super;

public class Sub extends Super {
	public Sub() {
		this.publicData = 10;
		this.protectedData = 20;
		//this.defaultData = 30;
		//Super와 같은 Package가 아니기 때문에 접근불가
		//this.privateData = 40;
		//접근불가 -> Super의 Class 안에서만
		//priavteData로 접근가능
	}
}
