package com.company;

import java.io.NotActiveException;
import java.util.Hashtable;
import java.util.TreeMap;

interface Player{
    public void assignWeapon(String weapon);
    public void mission();
}
class Terrorist implements Player{
    private String weapon; // extrinsic
    @Override
    public void mission() { // intrinsic
        System.out.println("Terrorist "+ weapon);
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }
}
class AntiTerrorist implements Player{
    private String weapon; // extrinsic
    @Override
    public void mission() { // intrinsic
        System.out.println("Anti - Terrorist "+ weapon);
    }

    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }
}

// / / / /
class PlayerFactory{
    Hashtable<String,Player> cache = new Hashtable<String,Player>();
    Player p = null;
    public Player getPlayer(String type){
        if(cache.containsKey(type))
            p = cache.get(type);
        else
        {
            if(type.equals("Terrorist")){
                p = new Terrorist();
                cache.put("Terrorist",p);
            }
            else if(type.equals("AntiTerrorist")){
                p= new AntiTerrorist();
                cache.put("AntiTerrorist",p);
            }
            else {
                System.out.println("NOT FOUND !");
            }
        }
        return p;
    }
}

public class Design{
    public static void main(String[] args){
        PlayerFactory factory = new PlayerFactory();
        Terrorist t1 = (Terrorist) factory.getPlayer("Terrorist");
        t1.assignWeapon("Desert Eagle");
        t1.mission();
    }
}