package StrategyPattern;

public class Coffee implements Drink{

	@Override
	public void drinking() {
		// TODO Auto-generated method stub
		System.out.println("맛:상큼하고 달콤");
	}

	@Override
	public void isHot() {
		// TODO Auto-generated method stub
		System.out.println("주스는 차가운 것만 있습니다.");
	}

}
