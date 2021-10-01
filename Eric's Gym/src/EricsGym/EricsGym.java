package EricsGym;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import  java.util.Scanner;

public class EricsGym {

    public static void main(String[] args) {
        //Here we go
        //

        final  String FILL_WATER = "fill water";
        final String HELP = "help";
        boolean ENTER_GYM = false;
        boolean WORKING_OUT=false;
        final String TREADMILL = "treadmill";
        final String StairMachine = "stair machine";
        int waterLevel = 0;

        Treadmill treadmill = new Treadmill();
        StairMachine stairMachine = new StairMachine();

        Exercise  [] availableExercises = new Exercise[]{treadmill,stairMachine};


// Welcome to gym interface
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Eric's Gym");
        System.out.println("Enjoy your free water bottle.  You wont be able to work out when your water bottle is at 0%.");
        System.out.print("Please type Fill Water to start your workout: ");
        String waterInput = userInput.nextLine();
        String firstWorkout = "";
        String treadmillInput = "";
        String treadmillSpeedInput = "";
        String treadmillDurationInput = "";
        String treadmillInclineInput = "";
        int speedInputTreadmill = 0;
        while (ENTER_GYM == false){
            if (waterInput.toLowerCase().equals(FILL_WATER)){
                waterLevel = 100;
                System.out.println("Your water bottle is completely full.");
                System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                ENTER_GYM = true;
                firstWorkout = userInput.nextLine();}
            else{
                System.out.println("Please fill your water bottle");
                waterInput = userInput.nextLine();}}
//Picking the exercise
        while (WORKING_OUT == false){
            if (firstWorkout.toLowerCase().equals(HELP)){
                for (Exercise workouts: availableExercises){
                    System.out.println(workouts.getName());
                }firstWorkout = userInput.nextLine();}
            else if (firstWorkout.toLowerCase().equals(TREADMILL)){
                System.out.println("You just walked up to the treadmill. ");
                System.out.println("Please enter the speed (In mph): ");
                treadmillSpeedInput = userInput.next();
                speedInputTreadmill = Integer.parseInt(treadmillSpeedInput);
                if (treadmillSpeedInput.toLowerCase().equals(HELP)){
                    for (Exercise workouts: availableExercises){
                        System.out.println(workouts.getName());}firstWorkout = userInput.nextLine();}
                else if(speedInputTreadmill>=0 && speedInputTreadmill<=12){


                }


                System.out.println("Please enter the duration(In Minutes):  ");
                System.out.println("Please enter the incline percent(Between 0-15): ");
                System.out.println("Say HELP for further assistance. ");
                treadmillInput = userInput.nextLine();
                if (treadmillInput.toLowerCase().equals(HELP)){
                    System.out.println("Please enter a speed in mph from 0-12. ");
                    System.out.println("Please enter amount of time in minutes you would like to stay on the treadmill. ");
                    System.out.println("Please enter a percent between 0-15 to use as your incline. ");
                }

            }


        }}
}