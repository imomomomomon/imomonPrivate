package bit.pk.app2;

import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
//Ctrl + shift + o
public class InstanceClass extends Sub{//app2 Package의 Sub 클래스
	public static void main(String[] args) {
		Sub sb = new Sub();
		sb.publicData = 0;
		//sb.protectedData = 0; protected는 상속받지 않을떄
		//같은 Package가 아니면 접근불가
		
		InstanceClass inst = new InstanceClass();
		System.out.println("Super.publicdata : "+ inst.publicData);
		System.out.println("Super.protectedData : "+ inst.protectedData);
		//Protected는 상속을 받은 자식 클래스에서는 접근가능
		ArrayList list = new ArrayList();
		Vector<String> vec = new Vector<String>();
		Stack<String> st = new Stack<String>();
		
		BufferedOutputStream bs;
	}
}
