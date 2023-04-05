package StrategyPattern;

public class Pasta implements Eat{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("맛:크리미한 까르보나라");
	}

	@Override
	public void useEquipment() {
		// TODO Auto-generated method stub
		System.out.println("포크나 젓가락이 필요합니다.");
	}

}
