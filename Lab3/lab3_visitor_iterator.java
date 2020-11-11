import java.util.ArrayList;

//посетитель
interface Visitor{
    void visit_level(Level current_lvl);
}
//итератор
interface Iterator<Level>{
    void reset();
    boolean hasNext();
    Level next();
    void add(Level lvl);
}


//конкретный посетитель
class Mage implements Visitor{
    @Override
    public void visit_level(Level current_lvl) {
        if(current_lvl.beasts=="Элементали огня")
            System.out.println(current_lvl.beasts+"! Кастуем заморозку.");
        else if (current_lvl.beasts=="Элементали воды")
            System.out.println(current_lvl.beasts+"! Кастуем огонь.");
        else if (current_lvl.beasts=="Нежить")
            System.out.println(current_lvl.beasts+"! Кастуем магию света.");
        else if (current_lvl.beasts=="Тролли")
            System.out.println(current_lvl.beasts+"! Кастуем молнии.");
    }
}

abstract class Dungeon{
    // Подземелье, у которого есть несколько уровней
    public abstract void Accept(Visitor visitor);

}

class Level extends Dungeon{
    // Конкретный уровень подземелья
    int lvl_num;
    String beasts;

    Level(int lvl_num,String beasts){
        this.lvl_num=lvl_num;
        this.beasts=beasts;
    }

    void setBeasts(String beasts){ this.beasts=beasts;}
    String getBeasts(){ return this.beasts;}

    public void Accept(Visitor visitor){
        System.out.println("Уровень "+this.lvl_num);
        visitor.visit_level(this);
    }
}

//реализация итератора со структурой данных
class LevelIterator implements Iterator<Level>{

    private ArrayList<Level> levels=new ArrayList<>();
    private int lvl_index;

    LevelIterator(){
        lvl_index =0;
    }

    public void reset(){
        lvl_index =0;
    }

    public boolean hasNext() {
       if (lvl_index >= levels.size()) return false;
       else return true;
    }

    public Level next() {
        return levels.get(lvl_index++);
    }

    public void add(Level lvl){
        levels.add(lvl);
    }
}

public class Main {

    public static void main(String[] args) {
        Visitor visitor=(Visitor) new Mage();
        LevelIterator iterator = new LevelIterator();
        iterator.add(new Level(1,"Элементали огня"));
        iterator.add(new Level(2,"Элементали воды"));
        iterator.add(new Level(3,"Тролли"));
        iterator.add(new Level(4,"Нежить"));
        while(iterator.hasNext()){
            iterator.next().Accept(visitor);
        }
    }
}
