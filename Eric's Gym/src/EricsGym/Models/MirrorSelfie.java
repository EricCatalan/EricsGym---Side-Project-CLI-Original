package EricsGym.Models;

public class MirrorSelfie extends Exercise{
    private String walkUp = "You center yourself in front of the mirror. \n(•_•)\n( •_•)>⌐■-■\n(⌐■_■)\nYou are killing it... Lets keep going! \nPlease enter your next exercise: ";

    public MirrorSelfie() {
        super("Mirror Selfie", "Mental Boost");
    }

    public String getWalkUp() {
        return walkUp;
    }
}
