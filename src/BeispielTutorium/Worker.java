package BeispielTutorium;

public class Worker extends Person{
    private int workerId;


    public Worker(int alter, String vorName, String nachName, int workerId) {
        super(alter, vorName, nachName);
        this.workerId = workerId;
    }
    public Worker(){
        super();
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "Worker {" +
                "workerId=" + workerId +
                super.toString();
    }
}
