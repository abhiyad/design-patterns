package com.company;
class Singleton{
    private int data =0;
    private Singleton(){}
    private static class SingletonHelper{
        private static final Singleton uniqueInstance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHelper.uniqueInstance;
    }
    ////


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

public class Design {
    public static void main(String[] args){
        Singleton  a = Singleton.getInstance();
        a.setData(55);
        Singleton b = Singleton.getInstance();
        System.out.println(a.getData() + " " + b.getData());
    }

}
