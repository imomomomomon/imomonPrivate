package bit.basic.obj1;
//overloading 과적
public class ObjectEx2 {
	public void add(int x) {
		System.out.println(x);
	}
	public void add(short x) {
		System.out.println(x +"(short x)");
	}
	public void add(int x,int y) {
		System.out.printf("%3d %3d",x,y);
		System.out.println();
	}
	public void add(int x,long y) {
		System.out.printf("%3d %3d(long y)",x,y);
		System.out.println();
	}
	public void add(long x,int y) {
		System.out.printf("%3d(long x) %3d",x,y);
		System.out.println();
	}
	public static void main(String[] args) {
		ObjectEx2 o = new ObjectEx2();
		
		o.add(1);
		o.add((short)1);
		o.add(10,20);
		o.add(10,(long)20);
		o.add(10L,20);
	} 
}
