package EricsGym.Models;

public class Treadmill extends Exercise{
    //Instance Variables

    private double speed;
    private String walkUp = "You just walked up to the treadmill. " + '\n';
    private double minutes=0;
    //Getters

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }

    public String getWalkUp() {
        return walkUp;
    }

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

    public boolean setSpeedValid(double inputSpeed){
        boolean validSpeed = false;
        if (inputSpeed <=12 && inputSpeed >=0){
            validSpeed = true;
        }else {validSpeed=false;}
    return validSpeed;
    }

    public String mphHelp (){
        return "Please enter a MPH between 0-12";}

    public String speedInput(){
        return "Please enter the speed (In mph):";
    }
    public boolean setMinutesValid(double minutes){
        boolean validMinutes = false;
        if(minutes >0){
            validMinutes = true;
        }else {
            validMinutes=false;
        }return validMinutes;
    }
    public String minuteInput(){
        return "Please enter the amount of minutes you are going to be using the treadmill for: ";
    }
    public String exit(){
        return "You wiped down the treadmill.  What would you like to do next?: ";
    }

}