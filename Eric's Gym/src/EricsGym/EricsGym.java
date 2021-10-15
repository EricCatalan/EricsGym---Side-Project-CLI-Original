package EricsGym;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import  java.util.Scanner;

public class EricsGym {
private Menu menu;
private WatterBottle userWaterBottle = new WatterBottle();
private final String leave ="leave";
private final  String FILL_WATER = "fill water";
private final String HELP = "help";
private boolean ENTER_GYM = false;
private String waterInput;
private boolean start=false;



    public EricsGym(Menu menu){
        this.menu = menu;
    }

    public void run() throws NumberFormatException{
        System.out.println("Welcome to Eric's Gym");
        System.out.println("Enjoy your free water bottle.  You wont be able to work out when your water bottle is at 0%.");
        System.out.print("Please type Fill Water to start your workout: ");

       while(!start) {
           try {
               waterInput = (String) menu.getUserInputCLI();
               start = true;
           } catch (ClassCastException cce) {
               System.out.println("Please don't enter a number: ");
           }
       }

        while (!ENTER_GYM) {
            if (waterInput.toLowerCase().equals(leave)) {
                System.out.println("Thanks for coming to Eric's Gym! ");
                System.exit(1);
            } else if (waterInput.toLowerCase().equals(FILL_WATER)) {
                System.out.println( userWaterBottle.fillWater());
                System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                ENTER_GYM = true;
                String currentWorkout = (String) menu.getUserInput();
            } else {
                System.out.println("Please fill your water bottle");
            try{
              waterInput = (String) menu.getUserInputCLI();}
            catch(ClassCastException cce){
                System.out.println("Please don't enter a number: ");
            }
            }
        }



//        if(menu.isADouble){
//            System.out.println("Yay I did it, this is a double   " + menu.getUserInput());
//        }else{
//            System.out.println("This is a string boooo    " + menu.getUserInput());
//        }
//        String choice = (String) menu.getUserInputCLI();
    }
    public static void main(String[] args) {
        //Attempt Number 2
        Menu menu = new Menu(System.in, System.out);
        EricsGym eg = new EricsGym(menu);
        eg.run();















      /*  //Here we go
        //
        final String leave ="leave";
        final  String FILL_WATER = "fill water";
        final String HELP = "help";
        boolean ENTER_GYM = false;
        boolean WORKING_OUT=false;
        final String TREADMILL = "treadmill";
        final String StairMachine = "stair machine";
        boolean isValid = false;


        Treadmill treadmill = new Treadmill();
        StairMachine stairMachine = new StairMachine();

        Exercise  [] availableExercises = new Exercise[]{treadmill,stairMachine};
        WatterBottle userWaterBottle = new WatterBottle();


// Welcome to gym interface
    Scanner userInput = new Scanner(System.in);
    System.out.println("Welcome to Eric's Gym");
    System.out.println("Enjoy your free water bottle.  You wont be able to work out when your water bottle is at 0%.");
    System.out.print("Please type Fill Water to start your workout: ");
    String waterInput = userInput.nextLine();
    String firstWorkout = "";
    String currentWorkout = "";
    String treadmillInput = "";
    String treadmillSpeedInput = "";
    String treadmillDurationInput = "";
    String treadmillInclineInput = "";
    double speedInputTreadmill = 0;
    while (ENTER_GYM == false) {
        if (waterInput.toLowerCase().equals(leave)) {
            System.out.println("Thanks for coming to Eric's Gym! ");
            System.exit(1);
        } else if (waterInput.toLowerCase().equals(FILL_WATER)) {
            System.out.println(userWaterBottle.fillWater());
            System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
            ENTER_GYM = true;
            firstWorkout = userInput.nextLine();
            currentWorkout = firstWorkout;
        } else {
            System.out.println("Please fill your water bottle");
            waterInput = userInput.nextLine();
        }
    }
//Picking the exercise
    while (ENTER_GYM = true) {
        if (currentWorkout.toLowerCase().equals(HELP)) {
            for (Exercise workouts : availableExercises) { //If they ask for help print out the names
                System.out.println(workouts.getName());
            }
            currentWorkout = userInput.nextLine();
        }
        //If they choose the treadmill
    while ((currentWorkout.toLowerCase().equals(TREADMILL))) {
            System.out.println(treadmill.walkUp());
            treadmillSpeedInput = userInput.next();
            while (treadmillSpeedInput.toLowerCase().equals(HELP)) { // Seeing if they need help
                System.out.println(treadmill.mphHelp());
                treadmillSpeedInput = userInput.nextLine();
            } // Print out all the exercises if they need help
            while(!isValid && !(treadmillSpeedInput.toLowerCase().equals(HELP))){
                isValid = true;
                try{speedInputTreadmill = Double.parseDouble(treadmillSpeedInput);}
                catch (NumberFormatException nfe ){
                    treadmillSpeedInput = userInput.nextLine();
                    isValid = false;
                    if (!treadmillSpeedInput.toLowerCase().equals(HELP) && !(speedInputTreadmill >= 0 && speedInputTreadmill <= 12)){
                        System.out.println("Please enter a valid number: ");
                    }
                }}// Making the string a number
            if (speedInputTreadmill >= 0 && speedInputTreadmill <= 12) {
                treadmill.setSpeed(speedInputTreadmill);
                System.out.println(treadmill.getSpeed());
            }else{
                System.out.println(treadmill.mphHelp());
                treadmillSpeedInput = userInput.nextLine();
            }
        }


//        System.out.println("Please enter the duration(In Minutes):  ");
//        System.out.println("Please enter the incline percent(Between 0-15): ");
//        System.out.println("Say HELP for further assistance. ");
//        treadmillInput = userInput.nextLine();
//        if (treadmillInput.toLowerCase().equals(HELP)) {
//            System.out.println("Please enter a speed in mph from 0-12. ");
//            System.out.println("Please enter amount of time in minutes you would like to stay on the treadmill. ");
//            System.out.println("Please enter a percent between 0-15 to use as your incline. ");
//        }

    }


        }
*/}}