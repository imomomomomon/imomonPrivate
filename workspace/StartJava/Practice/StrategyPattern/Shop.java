package StrategyPattern;

public abstract class Shop {
	private String name;
	private Eat eat;
	private Drink drink;
	
	public Shop(String name, Eat eat, Drink drink) {
		super();
		this.name = name;
		this.eat = eat;
		this.drink = drink;
	}
	
	public void printEat() {
		eat.useEquipment();
		eat.eat();
	}
	
	public void printDrink() {
		drink.isHot();
		drink.drinking();
	}
}
