package StrategyPattern;

public class Juice implements Drink{

	@Override
	public void drinking() {
		// TODO Auto-generated method stub
		System.out.println("맛:씁슬하지만 풍미가 가득");
	}

	@Override
	public void isHot() {
		// TODO Auto-generated method stub
		System.out.println("따뜻한 아메리카노");
	}

}
