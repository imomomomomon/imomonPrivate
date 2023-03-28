package bit.basic.obj2;

public class LoginAction extends Action {
	private String path;
	private boolean redirect; // true 직접 false 간접
	
	public LoginAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForward execute() {
		// TODO Auto-generated method stub
		System.out.println("LoginAction");
		return new ActionForward(path,redirect);
	}
	
}
