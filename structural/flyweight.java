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
    public Player getPlayer(String type) throws NotActiveException {
        if(cache.containsKey(type))
            return cache.get(type);
        else
        {
            if(type.equals("Terrorist")){
                Terrorist player = new Terrorist();
                cache.put("Terrorist",player);
            }
            else if(type.equals("AntiTerrorist")){
                AntiTerrorist player = new AntiTerrorist();
                cache.put("AntiTerrorist",player);
            }
            else{
                throw new NotActiveException("NOT FOUND !");
            }
        }
        return cache.get(type);
    }
}

public class Design{
    public static void main(String[] args) throws NotActiveException {
        PlayerFactory factory = new PlayerFactory();
        Terrorist t1 = (Terrorist) factory.getPlayer("Terrorist");
        t1.assignWeapon("Desert EAgle");
        t1.mission();
    }
}