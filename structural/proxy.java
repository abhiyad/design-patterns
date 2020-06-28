package com.company;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

interface Internet{
    public void connect(String website);
}
class RealInternet implements Internet{
    @Override
    public void connect(String website) {
        System.out.println("CONNECTED TO ...  " + website);
    }
}

class Proxy implements Internet{
    Set<String> bannedSites = new HashSet<String>();

    private RealInternet realInternet = new RealInternet();
    public Proxy() {
        System.out.println("PROXY SET UP");
        bannedSites.add("abc");
    }
    @Override
    public void connect(String website) {
        if(bannedSites.contains(website)){
            System.out.println("BANNED");
        }
        else{
            realInternet.connect(website);
        }
    }
}

public class Design{
    public static void main(String[] args){
        Proxy internet = new Proxy();
        internet.connect("abc");
        internet.connect("google.com");
    }
}