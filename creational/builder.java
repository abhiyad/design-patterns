interface Item{
	public String name();
	public Packing packing();
	public float price();
}

//// 


abstract class Burger implements Item{
	@Override
	public Packing packing(){
		return new Wrapper();
	}
	@Override
	public abstract float price();
	@Override
	public abstract String name();
}

Class VegBurger extends Burger{
	@Override
	public float price(){
		return 1.0f;
	}
	@Override
	public float name(){
		return "Veg Burger";
	}
}

Class ChichenBurger extends Burger{
	@Override
	public float price(){
		return 2.0f;
	}
	@Override
	public float name(){
		return "Chicken Burger";
	}
}


/// 

abstract class Drink implements Item{
	@Override
	public Packing packing(){
		return new Bottle();
	}
	@Override
	public abstract float price();
	@Override
	public abstract String name();
}

Class Pepsi extends Drink{
	@Override
	public float price(){
		return 0.1f;
	}
	@Override
	public float name(){
		return "Pepse";
	}
}

Class Coke extends Drink{
	@Override
	public float price(){
		return 0.2f;
	}
	@Override
	public float name(){
		return "Coke";
	}
}


////// 

interface Packing {
	public String pack();
}

class Wrapper implements Packing{
	@Override
	public String pack{
		return "Wrapper";
	}
}

class Bottle implements Packing{
	@Override
	public String pack{
		return "Bottle";
	}
}

//// 

public class Meal{
	private List<Item> items;

	public Meal(){
		items = new ArrayList<Item>();
	}
	public void addItem(Item item){
		items.add(item);
	}
	public float getCost(){
		float cost=0.0f;
		for (Item item:items){
			cost+=item.price();
		}
		return cost;
	}
	public void showItems(){
		for(Item item:items){
			SOPLN(item.name(),item.price(),item.packing());
		}
	}
}

///// 

interface MealBuilderInterface{
	void buildBurger();
	void buildDrink();
	Meal getMeal();
}

class VegMealBuilder implements MealBuilderInterface{
	private Meal vegMeal = new Meal();
	@Override
	public void buildBurger(){
		vegMeal.addItem(new VegBurger());
	}
	@Override
	public void buildDrink(){
		vegMeal.addItem(new Coke());
	}
	@Override
	public void getMeal(){
		return vegMeal;
	}
}

class NonVegMealBuilder implements MealBuilderInterface{
	private Meal nonVegMeal = new Meal();
	@Override
	public void buildBurger(){
		nonVegMeal.addItem(new ChichenBurger());
	}
	@Override
	public void buildDrink(){
		nonVegMeal.addItem(new Pepsi());
	}
	@Override
	public void getMeal(){
		return nonVegMeal;
	}
}

//// 

class Director{
	MealBuilderInterface myBuilder;
	public void contruct(MealBuilderInterface builder){
		myBuilder=builder;
		builder.buildBurger();
		builder.buildDrink();
	}
}

////// 

public class Client {
	public static void main(){
		Director director = new Director();
		MealBuilderInterface vegMealBuilder = new VegMealBuilder();
		MealBuilderInterface nonVegMealBuilder = new NonVegMealBuilder();
		
		director.contruct(vegMealBuilder);
		director.contruct(nonVegMealBuilder);
		
		vegMeal.showItems();
		nonVegMeal.showItems();
			
	}	
}