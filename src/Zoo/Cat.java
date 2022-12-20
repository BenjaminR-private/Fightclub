package Zoo;

public class Cat extends Animal {
    String name;
    public Cat(double weight, double height, double length, boolean isCarni, String name) {
        super(weight, height, length, isCarni);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tCat{" +
                "name='" + name + '\'' +
                '}';
    }

    public Cat(){
        super();
    }
    public Cat(String name){
        super();
        this.name = name;
    }

    public void miau() {
        System.out.println("Miau");
    }
}
