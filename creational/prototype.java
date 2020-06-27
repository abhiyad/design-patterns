package com.company;

import java.util.Hashtable;

abstract class Shape implements Cloneable{
    private String id;
    protected String type;
    abstract void draw();
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Square extends Shape{
    public Square(){
        type = "SQUARE";
    }

    @Override
    void draw() {
        System.out.println("DRAW A SQUARE");
    }
}

class Circle extends Shape{
    public Circle(){
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("DRAW A Circle");
    }
}

// / / / / /

class ShapeCache{
    private static Hashtable<String,Shape> shapeMap = new Hashtable<String,Shape>();
    public static Shape getShape(String id){
        Shape cachedShape = shapeMap.get(id);
        return (Shape)cachedShape.clone();
    }
    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);
    }
}

public class Design{
    public static void main(String[] args){
        ShapeCache.loadCache();
        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println(clonedShape.getType());
    }
}