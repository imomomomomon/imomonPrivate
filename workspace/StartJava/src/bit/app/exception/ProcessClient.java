package bit.app.exception;

public class ProcessClient {
	ProcessInter p;
	
	public ProcessClient() {
		// TODO Auto-generated constructor stub
		p = new Process();
	}
	
	public void action() {
		p.fileCheck();
		System.out.println("action");
	}
	
	public static void main(String[] args) {
		ProcessClient p = new ProcessClient();
		try {
			p.action();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
