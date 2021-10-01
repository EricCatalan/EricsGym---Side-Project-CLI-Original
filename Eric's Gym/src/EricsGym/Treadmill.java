package EricsGym;

public class Treadmill extends Exercise{
    //Instance Variables
    private double speed;
    //Getters

    public double getSpeed() {
        return speed;
    }

    //Constructor
    public Treadmill() {
        super("Treadmill", "Running");
    }

    @Override
    public String getName() {
        return super.getName();
    }
}