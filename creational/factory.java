package com.company;
interface AnimalInterface{
    void makeSound();
}

class Tiger implements AnimalInterface{
    @Override
    public void makeSound(){
        System.out.println("TIGER MAKES SSS");
    }
}

class Duck implements AnimalInterface{
    @Override
    public void makeSound(){
        System.out.println("Duck MAKES quack");
    }
}

// /// / // /

abstract class AnimalFactoryInterface{
    public abstract AnimalInterface getAnimalType(String type) throws ClassNotFoundException;
}

class ConcreteAnimalFactory extends AnimalFactoryInterface{
    public AnimalInterface getAnimalType(String type) throws ClassNotFoundException {
        if (type=="DUCK")return new Duck();
        else if (type=="TIGER")return new Tiger();
        else throw new ClassNotFoundException("NOT FOUND");
    }
}
// // / /
public class Design {
    public static void main(String[] args) throws ClassNotFoundException {
        AnimalFactoryInterface animalFactory = new ConcreteAnimalFactory();
        AnimalInterface duck = animalFactory.getAnimalType("DUCK");
        AnimalInterface tiger = animalFactory.getAnimalType("TIGER");

        duck.makeSound();
        tiger.makeSound();
    }

}
