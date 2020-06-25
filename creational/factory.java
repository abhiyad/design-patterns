interface AnimalInterface{
	void makeSound();
}

class Tiger implements AnimalInterface{
	@Override
	public void makeSound(){
		print("TIGER MAKES SSS");
	}
}

class Duck implements AnimalInterface{
	@Override
	public void makeSound(){
		print("Duck MAKES quack");
	}
}

// /// / // / 

public abstract class AnimalFactoryInterface{
	public abstract AnimalInterface getAnimalType(String type) throws exception;
}

class ConcreteAnimalFactory extends AnimalFactoryInterface{
	public AnimalInterface getAnimalType(String type){
		if (type=="DUCK")return new Duck();
		if (type=="Tiger")return new TIger();
	}
}	
// // / / 

class Client{
	AnimalFactoryInterface animalFactory = new ConcreteAnimalFactory();
	AnimalInterface duck = animalFactory.getAnimalType("DUCK");
	AnimalInterface tiger = animalFactory.getAnimalType("tiger");

	duck.makeSound();
	tiger.makeSound();

}