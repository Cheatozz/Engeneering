package com.company;

interface IWeapon{
    String weaponType();
}

interface Character{
    String equip();
}

class Warrior implements Character{

    private IWeapon iWeapon;

    public Warrior(IWeapon iWeapon){
        System.out.println("Воин выбирает оружие.");
        this.iWeapon=iWeapon;
    }

    public String equip(){
        System.out.print("Воин взял ");
        return iWeapon.weaponType();
    }
}

class CharacterEquip {

    public static Character warriorEquip(int enemyArmour){
        if(enemyArmour>10){
            System.out.print("Бронированный противник. ");
            return new Warrior(new Sword());
        }
        else {
            System.out.print("Противник в слабой броне. ");
            return new Warrior(new Hammer());
        }
    }
}

class Sword implements  IWeapon{
    public String weaponType(){
        return "меч!";
    }
}

class Hammer implements  IWeapon{
    public String weaponType(){
        return "молот!";
    }
}

public class Main {

   public static void main(String[] args) {
       Character w1 = CharacterEquip.warriorEquip(9);
       System.out.println(w1.equip());
    }
}
