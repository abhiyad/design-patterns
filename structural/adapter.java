package com.company;

interface Duck{
    public void quack();
    public void fly();
}

class IndianDuck implements Duck{
    public void quack(){
        System.out.println("QUACK");
    }
    public void fly(){
        System.out.println("DUCK FLY");
    }
}

///// // / / /

interface Turkey{
    public void gobble();
    public void fly();
}

class WildTurkey implements Turkey{
    public void gobble(){
        System.out.println("GOBBLE");
    }
    public void fly(){
        System.out.println("TURKEY FLY");
    }
}
//   / / / // /
class TurkeyAdapter implements Duck{
    Turkey turkey;
    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gobble();
    }

    public void fly(){
        turkey.fly();
        turkey.fly();
        turkey.fly();
    }
}



public class Design {
    public static void main(String[] args){
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

}
