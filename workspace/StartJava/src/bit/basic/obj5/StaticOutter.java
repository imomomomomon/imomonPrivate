package bit.basic.obj5;

public class StaticOutter {
	private static int outterStaticValue;
	private int instatnceOutterValue;
	
	public static class StaticInner {
		private static int innerValue;
		public StaticInner() {
			outterStaticValue = 10;
		}
		public void innerMethod() {
			int value;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
