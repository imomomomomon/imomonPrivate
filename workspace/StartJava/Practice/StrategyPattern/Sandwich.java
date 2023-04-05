package StrategyPattern;

public class Sandwich implements Eat{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("맛:싱싱한 채소가 어우러져 있는 샌드위치");
	}

	@Override
	public void useEquipment() {
		// TODO Auto-generated method stub
		System.err.println("맨손으로 먹을수 있습니다.");
	}

}
