
interface CircleStrategy {
    double execute();
}

class Circle {
    private double r;
    private CircleStrategy strategy;
    Circle( double r){
        this.r=r;

    }
    public void setStrategy(CircleStrategy strategy) {
        this.strategy = strategy;

    }
    public double execute(){
        return this.strategy.execute();
    }
    double getR(){ return r;}
}

class CircleArea implements CircleStrategy{
    private double r;
    CircleArea(Circle c){
    this.r=c.getR();
    }

public double execute() {
        return Math.PI*Math.pow(r,2);
    }
}

class CirclePerimeter implements CircleStrategy{
    private double r;
    CirclePerimeter(Circle c){
        this.r=c.getR();
    }

    public double execute() {
        return 2*Math.PI*r;
    }
}

public class Main {

    public static void main(String[] args) {
        Circle c = new Circle(25.25);
        System.out.println("Input for Circle is: Pink, r = 25.25");
        c.setStrategy(new CircleArea(c));
        System.out.println("Area of a circle is : "+c.execute());
        c.setStrategy(new CirclePerimeter(c));
        System.out.println("Perimeter of a circle is : "+c.execute());
    }
}
