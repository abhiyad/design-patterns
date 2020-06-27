package com.company;

import sun.util.resources.cldr.pl.TimeZoneNames_pl;

interface Shape{
    public void draw();
}
class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("CIRCLE ");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("RECTANGLE ");
    }
}
abstract class ShapeDecorator implements Shape{
    Shape shape;
    public ShapeDecorator(Shape shape){
        this.shape = shape;
    }
    public abstract void draw();
}

class RedDecorator extends ShapeDecorator{
    public RedDecorator(Shape shape){
        super(shape);
    }
    @Override
    public void draw() {
        System.out.println("RED COLOR" + shape.getClass());
    }
}

class GreenDecorator extends ShapeDecorator{
    public GreenDecorator(Shape shape){
        super(shape);
    }

    @Override
    public void draw() {
        System.out.println("GREEN COLOR " + shape.getClass());
    }
}


public class Design{
    public static void main(String[] args){
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        circle.draw();
        rectangle.draw();
        ShapeDecorator s1 = new GreenDecorator(circle);
        s1.draw();
    }
}