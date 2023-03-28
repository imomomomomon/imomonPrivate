package Practice;

public class CharSkill_Archer implements CharSkill_Handler{

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		System.out.println("활을 쏘다");
	}

	@Override
	public void Guard() {
		// TODO Auto-generated method stub
		System.out.println("회피하다");
	}

	@Override
	public void Skill() {
		// TODO Auto-generated method stub
		System.out.println("강력한 한방을 쏘다");
	}
	
}
