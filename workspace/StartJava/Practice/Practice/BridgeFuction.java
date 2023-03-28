package Practice;

public class BridgeFuction {
	public static void main(String[] args) {
		Player type01 = new Warrior(new CharSkill_Warrior());
		Player type02 = new Archer(new CharSkill_Archer());
		
		type01.Activate();
		type02.Activate();
	}
}

class Warrior extends Player{

	public Warrior(CharSkill_Handler handler) {
		super(handler);
	}

	public void Activate()
	{
		System.out.println("전사는 행동을 개시했다.");
		super.Attack();
		super.Guard();
		super.Skill();
	}
}

class Archer extends Player{

	public Archer(CharSkill_Handler handler) {
		super(handler);
	}

	public void Activate()
	{
		System.out.println("궁수는 행동을 개시했다.");
		super.Attack();
		super.Guard();
		super.Skill();
	}
}

class Player {
	private CharSkill_Handler handler_skill;
	
	public Player(CharSkill_Handler handler) {
		handler_skill = handler;
	}
	
	public void Activate() {
		
	}
	
	protected void Attack() {
		handler_skill.Attack();
	}
	
	protected void Guard()	{
		handler_skill.Guard();
	}
	
	protected void Skill() {
		handler_skill.Skill();
	}
}

