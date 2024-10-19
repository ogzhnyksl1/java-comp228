package Exercise2;

public abstract class GameTester {
    protected String name;
    protected boolean status; // true = full-time, false = part-time

    public GameTester(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    public abstract double determineSalary();
}
