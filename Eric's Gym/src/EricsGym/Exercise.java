package EricsGym;

public class Exercise {
    //Instance Variables
    private String name;
    private String activity;
    private boolean isOn =false;
    private String walkUp = "You walked up to " + this.getName() ;
    //Constructor
    public Exercise(String name, String activity){
        this.name=name;
        this.activity=activity;
    }
    // Getters
    public String getName() {
        return this.name;}
    public String getActivity() {
        return activity;}
    public void on(boolean isOn){this.isOn=isOn;}

    public String walkUp(){
        return walkUp;
    }

}

