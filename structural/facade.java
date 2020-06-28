package com.company;
interface Hotel{
    public Menus getMenu();
}
interface Menus{
    public void details();
}
class VegMenu implements Menus{
    @Override
    public void details() {
        System.out.println("VEG MENU");
    }
}
class VegHotel implements Hotel{
    @Override
    public Menus getMenu() {
        VegMenu vegMenu = new VegMenu();
        return vegMenu;
    }
}

// Add non veg menu hotel and menu too like we did for VEG

class HotelKeeper{
    public VegMenu getVegMenu(){
        VegHotel v = new VegHotel();
        return (VegMenu) v.getMenu();
    }

    // add similar methods for other non veg too
}

public class Design{
    public static void main(String[] args){
        HotelKeeper h = new HotelKeeper();
        h.getVegMenu().details();
    }
}