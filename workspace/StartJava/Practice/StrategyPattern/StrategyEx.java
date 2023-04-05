package StrategyPattern;

public class StrategyEx {
	
	public void print() {
		
		Shop []shops = new Shop[2];
		
		shops[0] = new CoffeeShop("스타벅스", 
				new Sandwich(), new Coffee());
		shops[1] = new WesternFood("백종원 양식집", 
				new Pasta(), new Juice());
		
		for(int i = 0; i < 2; i++) {
			shops[i].printEat();
			shops[i].printDrink();
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		StrategyEx ex = new StrategyEx();
		ex.print();
	}
}
