package com.company;

abstract class Vehicle{
    protected Workshop w1;
    protected Workshop w2;
    public abstract void manufacture();
    public Vehicle(Workshop w1,Workshop w2){
        this.w1 = w1;
        this.w2 = w2;
    }
}

interface Workshop{
    public void work();
}

class Workshop1 implements Workshop{
    @Override
    public void work() {
        System.out.println("Produce");
    }
}

class Workshop2 implements Workshop{
    @Override
    public void work() {
        System.out.println("Assemble");
    }
}

class Car extends Vehicle{
    @Override
    public void manufacture() {
        w1.work();
        w2.work();
    }

    public Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }
}

class Bike extends Vehicle{
    @Override
    public void manufacture() {
        w1.work();
        w2.work();
    }

    public Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }
}

public class Design{
    public static void main(String[] args){
        Vehicle v1 = new Bike(new Workshop1(),new Workshop2());
        Vehicle v2 = new Bike(new Workshop1(),new Workshop2());
        v1.manufacture();
        v2.manufacture();
    }
}