package EricsGym.Models;


public class StairMachine extends Exercise{
    private String walkUp = "You just walked up to the Stair Machine: "+ '\n';
    private double stepsPerMinute=0;
    private double minutes=0;

    public StairMachine(){
        super("Stair Machine", "Walking");
    }

    public double getMinutes() {
        return minutes;
    }

    public void setMinutes(double minutes) {
        this.minutes = minutes;
    }
    public String getWalkUp() {
        return walkUp;
    }

    public double getStepsPerMinute() {
        return stepsPerMinute;
    }

    public void setStepsPerMinute(double stepsPerMinute) {
        this.stepsPerMinute = stepsPerMinute;
    }
    public String stepsPerMinuteInput(){
        return "Please enter your steps per minute: ";
    }

    public boolean setSPMValid(double stepsPerMinute){
        boolean validSpeed = false;
        if (stepsPerMinute <=174 && stepsPerMinute >=0){
            validSpeed = true;
        }else {validSpeed=false;}
        return validSpeed;
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
        return "Please enter the amount of minutes you are going to be using the Stair Machine for: ";
    }
    public String exit(){
        return "You wiped down the Stair Machine.  What would you like to do next?: ";
    }

    public String mphHelp (){
        return "Please enter a SPM between 0-174";}

}
