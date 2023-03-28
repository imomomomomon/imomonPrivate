package bit.basic.obj2;

public class ActionFactory {//command에 따라서 Action을 생성하는 공장
	
	private ActionFactory() { }
	private static ActionFactory inst;
	public static ActionFactory getInst() {
		if(inst == null)
			inst = new ActionFactory();
		return inst;
	}
	
	public Action getAction(String command) {
		if(command.equals("login"))
			return new LoginAction("loginView", true);
		if(command.equals("list"))
			return new ListAction("listView", false);
		return null;
	}
}
