package BeispielTutorium;

public class Main {
    public static void main(String[] args){
        Person[] persons = new Person[5];
        persons[0] = new Student(35,"Ben", "Rah", 54651248 );
        persons[1] = new Worker(22,"Gerhart", "Wasanderes", 65442);
        persons[2] = new Student(18,"Milan", "Egal", 54682265 );
        persons[3] = new Worker(50,"Ricardo", "irgendwas", 5461248 );
        persons[4] = new Student(36,"Irgendwer", "Blabla", 5461248 );

        for(Person aPerson : persons){
            System.out.println(aPerson.toString());
        }
    }
}
