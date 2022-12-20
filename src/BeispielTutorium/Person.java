package BeispielTutorium;

public class Person {

    private int age;
    private String name;
    private String surName;

    public Person(int alter, String name, String surName) {
        this.age = alter;
        this.name = name;
        this.surName = surName;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {

        return  "age=" + age +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
