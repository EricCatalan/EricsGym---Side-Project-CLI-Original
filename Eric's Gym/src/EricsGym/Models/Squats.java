package EricsGym.Models;

public class Squats extends Exercise{

    private double  amountPerSet = 0;
    private double amountOfSets =0;
    private double weight = 0;
    private String walkUp = "You walk over to the corner of the gym where there are mats on the floor. "+ '\n';
    public Squats() {
        super("Squats", "Squats");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAmountPerSet() {
        return amountPerSet;
    }

    public String getWalkUp() {
        return walkUp;
    }

    public void setAmountPerSet(double amountPerSet) {
        this.amountPerSet = amountPerSet;
    }

    public double getAmountOfSets() {
        return amountOfSets;
    }

    public void setAmountOfSets(double amountOfSets) {
        this.amountOfSets = amountOfSets;
    }

    public boolean setAPSValid(double amountPerSet){
        boolean validAmount = false;
        if (amountPerSet >0){
            validAmount = true;
        }else {validAmount=false;}
        return validAmount;
    }
    public String amountPerSetInput(){
        return "Please enter the amount of reps per set: ";
    }
    public boolean setAOSValid(double amountOfSets){
        boolean validAmount = false;
        if (amountOfSets >0){
            validAmount = true;
        }else {validAmount=false;}
        return validAmount;
    }
    public String amountOfSetInput(){
        return "Please enter the amount of sets: ";
    }
    public boolean setWeightValid(double weight) {
        boolean validAmount = false;
        if (weight > 0) {
            validAmount = true;
        } else {
            validAmount = false;
        }
        return validAmount;
    }
    public String weightInput(){
        return "Please enter the amount of weight in lbs: ";
    }
    public String exit(){
        return "You rack the weight. Your legs are burning. What would you like to do next? ";
    }

}
