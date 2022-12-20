package Zoo;

public class Animal {
    private double weight;
    private double height;
    private double length;
    private boolean isCarn;

    public Animal(double weight, double height, double length, boolean isCarni) {
        this.weight = weight;
        this.height = height;
        this.length = length;
        this.isCarn = isCarni;
    }

    public Animal() {

    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isCarn() {
        return isCarn;
    }

    public void setCarn(boolean carn) {
        isCarn = carn;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                ", isCarn=" + isCarn +
                '}';
    }
}
