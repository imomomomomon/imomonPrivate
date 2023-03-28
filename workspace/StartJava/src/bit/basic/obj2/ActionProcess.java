package bit.basic.obj2;

import java.util.Scanner;
//MVC패턴, 스트레이티지 패턴
public class ActionProcess {
	private Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		while(true) {
			System.out.println("1.Login 2.List 3.Delete 4.Modify 5.Exit");
			String command = "";
			switch (scanner.nextInt()) {
			case 1:
				command="login";
				break;
			case 2:
				command="list";
				break;
			case 3:
				command="delete";
				break;
			case 4:
				command="modify";
				break;
			case 5:
				command="exit";
				return;
			default:
				command="Error";
				break;
			}
			//Action action = new ActionFactory()~
			Action action = ActionFactory.getInst().getAction(command);
			ActionForward af = action.execute();
			if(af.isRedirect()) {
				System.out.println(af.getPath()+"직접이동"); //Action action = new LoginAction();
			} else {
				System.out.println(af.getPath()+"간접이동"); //Action action = new ListAction();
			}
		}
	}
	public static void main(String[] args) {
		new ActionProcess().menu();
	}
}
