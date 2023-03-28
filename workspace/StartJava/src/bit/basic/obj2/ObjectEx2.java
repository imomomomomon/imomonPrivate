package bit.basic.obj2;

public class ObjectEx2 {
	private static ObjectEx2 inst;
	private ObjectEx2() {
		msg = "hi";
	}
	public static ObjectEx2 getInst() {
		if(inst == null)
			inst = new ObjectEx2();
		return inst;
	}
	
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
