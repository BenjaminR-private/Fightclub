package BeispielTutorium;

public class Student extends Person{
    private int matrikelNumber;



    public Student(int alter, String vorName, String nachName, int matrikelNumber) {
        super(alter, vorName, nachName);
        this.matrikelNumber = matrikelNumber;
    }

    public Student() {
        super();
    }

    public int getMatrikelNumber() {
        return matrikelNumber;
    }

    public void setMatrikelNumber(int matrikelNumber) {
        this.matrikelNumber = matrikelNumber;
    }
    @Override
    public String toString() {
        return "Student {" +
                "matrikelNumber=" + matrikelNumber +
                super.toString();
    }
}
