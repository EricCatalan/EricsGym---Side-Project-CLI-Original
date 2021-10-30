package EricsGym;

import EricsGym.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EricsGym {
private Menu menu;
private WatterBottle userWaterBottle = new WatterBottle();
private boolean ENTER_GYM = false;
private String waterInput;
private boolean start=false;
private Treadmill treadmill = new Treadmill();
private StairMachine stairMachine = new StairMachine();
private PushUps pushUps = new PushUps();
private Squats squats = new Squats();
private String currentWorkout = null;
private double numberInput =0;
private List<Exercise> exercises = new ArrayList<>();






    public EricsGym(Menu menu){
        this.menu = menu;
    }

    public void run() throws NumberFormatException{
        exercises.add(treadmill);
        exercises.add(stairMachine);
        exercises.add(pushUps);
        exercises.add(squats);
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
            if (waterInput.toLowerCase().equals("leave")) {
                System.out.println("Thanks for coming to Eric's Gym! ");
                System.exit(1);
            } else if (waterInput.toLowerCase().equals("fill water")) {
                System.out.println( userWaterBottle.fillWater());
                System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                currentWorkout = (String) menu.getUserInputCLI();
                ENTER_GYM = true;

            } else {
                System.out.println("Please fill your water bottle");
            try{
              waterInput = (String) menu.getUserInputCLI();}
            catch(ClassCastException cce){
                System.out.println("Please don't enter a number: ");
            }
            }
        }
        while(ENTER_GYM){
            //Treadmill Workout
            if(currentWorkout.toLowerCase().equals("treadmill") && userWaterBottle.getWaterLevel()>0){
                System.out.println( treadmill.getWalkUp());
                while(currentWorkout.toLowerCase().equals("treadmill")){
                try{
                    System.out.println(treadmill.speedInput());
                    numberInput = (double) menu.getUserInputCLI();
                    if(treadmill.setSpeedValid(numberInput)){
                        treadmill.setSpeed(numberInput);
                        while(currentWorkout.toLowerCase().equals("treadmill")){
                        try{
                            System.out.println(treadmill.minuteInput());
                            numberInput = (double) menu.getUserInputCLI();
                            if(treadmill.setMinutesValid(numberInput)){
                                treadmill.setMinutes(numberInput);
                                System.out.println(treadmill.exit());
                                userWaterBottle.drinkWater();
                                while(currentWorkout.toLowerCase().equals("treadmill")){
                                try{
                                currentWorkout = (String) menu.getUserInputCLI();
                                }
                                catch(ClassCastException cce){
                                    System.out.println("Please don't enter a number: ");
                            }}


                            }else{
                                System.out.println("Please enter a positive value: ");

                            }

                    }catch (ClassCastException cce){
                            System.out.print("Please only enter a numerical value. ");
                        }
                        }}
                        else{
                        System.out.println(treadmill.mphHelp());
                    }
                }
                catch (ClassCastException cce){
                    System.out.print("Please only enter a numerical value. ");
                }
            //Stair Machine Workout
            }}else if(currentWorkout.toLowerCase().equals("stair machine")&& userWaterBottle.getWaterLevel()>0){
                System.out.println( stairMachine.getWalkUp());
                while(currentWorkout.toLowerCase().equals("stair machine")) {
                    try {
                        System.out.println(stairMachine.stepsPerMinuteInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if (stairMachine.setSPMValid(numberInput)) {
                            stairMachine.setStepsPerMinute(numberInput);
                            while (currentWorkout.toLowerCase().equals("stair machine")) {
                                try {
                                    System.out.println(stairMachine.minuteInput());
                                    numberInput = (double) menu.getUserInputCLI();
                                    if (stairMachine.setMinutesValid(numberInput)) {
                                        stairMachine.setMinutes(numberInput);
                                        System.out.println(stairMachine.exit());
                                        userWaterBottle.drinkWater();
                                        while(currentWorkout.toLowerCase().equals("stair machine")){
                                        try {
                                            currentWorkout = (String) menu.getUserInputCLI();
                                        } catch (ClassCastException cce) {
                                            System.out.println("Please don't enter a number: ");
                                        }}
                                    } else {
                                        System.out.println("Please enter a positive value: ");

                                    }
                                } catch (ClassCastException cce) {
                                    System.out.print("Please only enter a numerical value. ");
                                }
                            }
                        } else {
                            System.out.println(stairMachine.mphHelp());
                        }

                    } catch (ClassCastException cce) {
                        System.out.print("Please only enter a numerical value. ");
                    }
                } }
            //PushUps
            if(currentWorkout.toLowerCase().equals("pushups") && userWaterBottle.getWaterLevel()>0){
                System.out.println( pushUps.getWalkUp());
                while(currentWorkout.toLowerCase().equals("pushups")){
                    try{
                        System.out.println(pushUps.amountPerSetInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if(pushUps.setAPSValid( numberInput)){
                            pushUps.setAmountPerSet(numberInput);
                            while(currentWorkout.toLowerCase().equals("pushups")){
                                try{
                                    System.out.println(pushUps.amountOfSetInput());
                                    numberInput = (double) menu.getUserInputCLI();
                                    if(pushUps.setAOSValid(numberInput)){
                                        pushUps.setAmountOfSets( numberInput);
                                        System.out.println(pushUps.exit());
                                        userWaterBottle.drinkWater();
                                        while(currentWorkout.toLowerCase().equals("pushups")){
                                            try{
                                                currentWorkout = (String) menu.getUserInputCLI();
                                            }
                                            catch(ClassCastException cce){
                                                System.out.println("Please don't enter a number: ");
                                            }}


                                    }else{
                                        System.out.println("Please enter a positive value: ");

                                    }

                                }catch (ClassCastException cce){
                                    System.out.print("Please only enter a numerical value. ");
                                }
                            }}
                        else{
                            System.out.println(treadmill.mphHelp());
                        }
                    }
                    catch (ClassCastException cce){
                        System.out.print("Please only enter a numerical value. ");
                    }
                }}
            //Squats
            if(currentWorkout.toLowerCase().equals("squats") && userWaterBottle.getWaterLevel()>0){
                System.out.println( squats.getWalkUp());
                while(currentWorkout.toLowerCase().equals("squats")){
                    try{
                        System.out.println(squats.amountPerSetInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if(squats.setAPSValid( numberInput)){
                            squats.setAmountPerSet(numberInput);
                            while(currentWorkout.toLowerCase().equals("squats")){
                                try{
                                    System.out.println(squats.amountOfSetInput());
                                    numberInput = (double) menu.getUserInputCLI();
                                    if(squats.setAOSValid(numberInput)){
                                        squats.setAmountOfSets( numberInput);
                                          while(currentWorkout.toLowerCase().equals("squats")){
                                            try{
                                                System.out.println(squats.weightInput());
                                                numberInput = (double) menu.getUserInputCLI();
                                                if(squats.setWeightValid(numberInput)){
                                                    squats.setWeight( numberInput);
                                                    System.out.println(squats.exit());
                                                    userWaterBottle.drinkWater();
                                                    while(currentWorkout.toLowerCase().equals("squats")){
                                                        try{
                                                            currentWorkout = (String) menu.getUserInputCLI();
                                                        }
                                                        catch(ClassCastException cce){
                                                            System.out.println("Please don't enter a number: ");
                                                        }}}
                                                    else{
                                                     System.out.println("Please enter a positive value: ");
                                         }}catch (ClassCastException cce){
                                                System.out.print("Please only enter a numerical value. ");
                                            }}
                                        }


                                    else{
                                        System.out.println("Please enter a positive value: ");

                                    }

                                }catch (ClassCastException cce){
                                    System.out.print("Please only enter a numerical value. ");
                                }
                            }}
                        else{
                            System.out.println(treadmill.mphHelp());
                        }
                    }
                    catch (ClassCastException cce){
                        System.out.print("Please only enter a numerical value. ");
                    }
                }}




            //Asking For Help
            else if(currentWorkout.toLowerCase().equals("help")){
                for(Exercise exercise: exercises){
                    System.out.println(exercise.getName());
                }
                System.out.println('\n' + "Please enter an exercise or say leave: ");
                currentWorkout = (String) menu.getUserInputCLI();
            }
            //Need to Fill Water
            else if(userWaterBottle.getWaterLevel()==0){
                boolean filled = false;
                System.out.print("Please type Fill Water to continue your workout: ");
                while(!filled){
                    waterInput = "";
                    try{
                    waterInput =(String) menu.getUserInputCLI();}
                    catch (ClassCastException cce) {
                        System.out.println("Please don't enter a number: ");
                    }while(!filled){
                        if (waterInput.toLowerCase().equals("leave")) {
                            System.out.println("Thanks for coming to Eric's Gym! ");
                            System.exit(1);
                        } else if (waterInput.toLowerCase().equals("fill water")) {
                            System.out.println( userWaterBottle.fillWater());
                            System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                            filled = true;
                            currentWorkout = (String) menu.getUserInputCLI();
                        }else {
                            System.out.println("Please fill your water bottle");
                            try{
                                waterInput = (String) menu.getUserInputCLI();}
                            catch(ClassCastException cce){
                                System.out.println("Please don't enter a number: ");
                            }
                             }}
            }}
            //Leave
            else if (currentWorkout.toLowerCase().equals("leave")) {
                System.out.println("Thanks for coming to Eric's Gym! ");
                System.exit(1);
            }
            else{
                System.out.println("Please enter an exercise, help or leave: ");
                currentWorkout = (String) menu.getUserInputCLI();
            }
    }}
    public static void main(String[] args) {
        //Attempt Number 2
        Menu menu = new Menu(System.in, System.out);
        EricsGym eg = new EricsGym(menu);
        eg.run();
    }}