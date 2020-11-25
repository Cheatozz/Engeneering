package com.company;

interface IAttack{
    String setAttack();
}

class Warrior{

    IAttack iAttack;

    void setAttack(IAttack iAttack){
        this.iAttack=iAttack;
    }

    String attack(){

        return iAttack.setAttack();
    }
}

class WarriorLogic {
    int enemyArmour;
    Warrior warrior;

    WarriorLogic(int enemyArmour, Warrior warrior){
        this.enemyArmour=enemyArmour;
        this.warrior=warrior;
    }
    void chooseAttackType(){
        if(enemyArmour>10){
            StrongAttack s1=new StrongAttack();
            warrior.setAttack(s1);
        }
        else {
            FastAttack f1=new FastAttack();
            warrior.setAttack(f1);
        }
    }
}

class FastAttack implements  IAttack{
    public String setAttack(){
        return "Быстрая атака!";
    }
}

class StrongAttack implements  IAttack{
    public String setAttack(){
        return "Сильная атака!";
    }
}

public class Main {

   public static void main(String[] args) {

       Warrior w1=new Warrior();
       WarriorLogic logic=new WarriorLogic(11,w1);
       logic.chooseAttackType();
       System.out.println(w1.attack());
    }
}
