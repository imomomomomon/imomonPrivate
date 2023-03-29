package bit.basic.obj5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LocalOutter extends JPanel {
	private int value;
	private static final int DATA = 100;//상수
	public class MemberInner{
		private int innerValue;
		public MemberInner() {
			System.out.println(DATA);
		}
		private void showLocal() {
		}
	}
	public void method1() {
		int localValue = 10;
		final int finalValue = 99;
		class LocalInner extends JFrame {
			public LocalInner() {
				value = 10;
				LocalOutter.this.value = 10;
			}
			public void showLocal() {
				System.out.println(finalValue);
				System.out.println(localValue);
				//localValue = 100;
				//localInner = 100; 지역변수 접근불가
				LocalOutter.MemberInner member =
						new LocalOutter().new MemberInner();
				member.showLocal();
			}
			
		}//inner
	}
	public static void main(String[] args) {
		LocalOutter local = new LocalOutter();
		local.method1();
	}
}
