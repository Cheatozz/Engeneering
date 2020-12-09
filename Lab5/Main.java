package com.company;

interface Hilt {
    String type="";
    String getType();
}
interface Blade {
    String type="";
    String getType();
}

interface WeaponPartFactory{
    Hilt createHilt();
    Blade createBlade();
}

class SaberHilt implements Hilt{
    String type = "закрытый";
    public String getType(){
        return type;
    }
}

class SaberBlade implements Blade{
    private String type = "изогнутый";
    public String getType(){
        return type;
    }
}

class SwordHilt implements Hilt{
    String type = "открытый";
    public String getType(){
        return type;
    }
}

class SwordBlade implements Blade{
    String type = "прямой";
    public String getType(){
        return type;
    }
}

class SwordPartFactory implements WeaponPartFactory{
    public SwordPartFactory(){
        System.out.println("Поступил заказ на меч");
    }

    public Hilt createHilt(){
        System.out.println("Делаем эфес меча");
        return new SwordHilt();
    }

    public Blade createBlade(){
        System.out.println("Делаем клинок меча");
        return new SwordBlade();
    }
}

class SaberPartFactory implements WeaponPartFactory{
    public SaberPartFactory(){
        System.out.println("Поступил заказ на саблю");
    }

    public Hilt createHilt(){
        System.out.println("Делаем эфес сабли");
        return new SaberHilt();
    }

    public Blade createBlade(){
        System.out.println("Делаем клинок сабли");
        return new SaberBlade();
    }
}

class Weapon{
    Hilt hilt;
    Blade blade;

    String getWeapon(){
        if(hilt.getType().equals("закрытый")&&blade.getType().equals("изогнутый"))
            name="Сабля";
        else name="Прямой меч";
        return "Сделанное оружие: " +name+ " (эфес "+ hilt.getType()+", клинок "+blade.getType()+")";
    }

    public static class Builder{
        Weapon weapon;
        WeaponPartFactory factory;

        Builder(WeaponPartFactory factory){
            weapon=new Weapon();
            this.factory=factory;
        }
        Builder setHilt(){
            weapon.hilt= factory.createHilt();
            return this;
        }
        Builder setBlade(){
            weapon.blade= factory.createBlade();
            return this;
        }
        Weapon build(){
            return weapon;
        }
    }
}

class Smithy{
    Weapon createWeapon(WeaponPartFactory order){
       return new Weapon.Builder(order).setHilt().setBlade().build();
    }
}

public class Main {

    public static void main(String[] args) {

        Smithy smithy = new Smithy();
        Weapon myWeapon = smithy.createWeapon(new SwordPartFactory());
        System.out.println(myWeapon.getWeapon());
    }
}
