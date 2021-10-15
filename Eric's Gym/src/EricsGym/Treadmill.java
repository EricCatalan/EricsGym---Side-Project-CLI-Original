package EricsGym;

public class Treadmill extends Exercise{
    //Instance Variables
    private double speed;
    //Getters

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //Constructor
    public Treadmill() {
        super("Treadmill", "Running");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String walkUp() {

        return ("You just walked up to the treadmill. " + '\n' + "Please enter the speed (In mph): ");
    }
    public String mphHelp (){
        return "Please enter a MPH between 0-12";}
}