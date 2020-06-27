package com.company;

import java.util.ArrayList;
import java.util.List;

interface Faculty{
    void getDetails();
}

class Professor implements Faculty{
    private String detail;
    public Professor(String detail){
        this.detail = detail;
    }

    @Override
    public void getDetails() {
        System.out.println(detail);
    }
}

class Supervisor implements Faculty{
    private String details;
    private List<Faculty> child = new ArrayList<Faculty>() {};
    @Override
    public void getDetails() {
        System.out.println(details);
        for(int i=0;i<child.size();i++){
            child.get(i).getDetails();
        }
    }

    public Supervisor(String details){
        this.details = details;
    }


    public void add(Faculty faculty){
        child.add(faculty);
    }
    public void remove(Faculty faculty){
        child.remove(faculty);
    }
}



public class Design{
    public static void main(String[] args){
        Supervisor dean = new Supervisor("DEAN OF COLLEGE");
        Supervisor ee = new Supervisor("HEAD EE");
        Supervisor cse = new Supervisor("HEAD CSE");
        //
        Professor p1 = new Professor("EE 1");
        Professor p2 = new Professor("EE 2");

        Professor q1 = new Professor("CSE 1");

        // / // / / /
        dean.add(ee);
        dean.add(cse);
        ee.add(p1);
        ee.add(p2);
        cse.add(q1);

        dean.getDetails(); // this gives complete heirarchy

    }
}