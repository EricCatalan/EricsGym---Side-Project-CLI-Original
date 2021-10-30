package EricsGym;

import EricsGym.Models.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class EricsGym {
private Menu menu;
private WatterBottle userWaterBottle = new WatterBottle();
private boolean ENTER_GYM = false;
private String waterInput;
private String nameInput;
private boolean start=false;
private SweatBank sweatBank = new SweatBank();
private Treadmill treadmill = new Treadmill();
private StairMachine stairMachine = new StairMachine();
private PushUps pushUps = new PushUps();
private Squats squats = new Squats();
private MirrorSelfie mirrorSelfie = new MirrorSelfie();
private Lunges lunges = new Lunges();
private Person person = new Person();
private Plank plank = new Plank();
private Bench bench = new Bench();
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
        exercises.add(mirrorSelfie);
        exercises.add(lunges);
        exercises.add(plank);
        exercises.add(bench);

        File logFile = new File("log.txt");
        boolean loggingEnabled = true;
        Logger gymLog = null;

        try{
            gymLog = new Logger(logFile,true);
        }catch(Exception e){
            loggingEnabled = false;
        }

        System.out.println("Welcome to Eric's Gym");
        System.out.println("Enjoy your free water bottle.  You wont be able to work out when your water bottle is at 0%.");
        System.out.println("If you would like to leave, please type leave when prompted for next exercise. ");
        System.out.print("Please type Fill Water to start your workout: ");



        while (!ENTER_GYM) {
            while(!start ) {
                try {
                    waterInput = (String) menu.getUserInputCLI();
                    if(waterInput.toLowerCase().equals("fill water")){
                    while(person.getName().equals("") ){
                    try{
                        System.out.println(person.getPrompt());
                        nameInput = (String) menu.getUserInputCLI();
                        person.setName(nameInput);
                        start = true;}
                    catch(ClassCastException cce) {
                        System.out.println("Please don't enter a number: ");
                    }}}
                    else{
                        System.out.print("Please type Fill Water to start your workout: \n");
                    }
                } catch (ClassCastException cce) {
                    System.out.println("Please don't enter a number: ");
                }
            }
            if (waterInput.toLowerCase().equals("leave")) {
                System.out.println("Thanks for coming to Eric's Gym! ");
                System.exit(1);
            } else if (waterInput.toLowerCase().equals("fill water")) {
                System.out.println( userWaterBottle.fillWater());
                System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                while(!ENTER_GYM) {
                    try {
                        currentWorkout = (String) menu.getUserInputCLI();
                        ENTER_GYM = true;
                    }catch(ClassCastException cce){
                        System.out.println("Please don't enter a number: ");
                    }
                }
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
                                treadmill.workout();
                                person.setLowerBodyLevel(1);
                                if(person.getLowerBodyLevel()>=6){
                                    System.out.println("Oh no! You over worked your lower body and had to leave!");
                                    currentWorkout = "leave";
                                }else {
                                sweatBank.setCaloriesSweatOut((int)treadmill.getCaloriesBurned());
                                gymLog.log(treadmill.getSpeed() + " MPH", treadmill.getMinutes() + " minutes ",(int)treadmill.getCaloriesBurned() + " calories burned using the " + treadmill.getName(),sweatBank.getCaloriesSweatOut() + " total calories burned for " + person.getName() );
                                userWaterBottle.drinkWater();
                                System.out.println('\n'+"You burned "+ (int) treadmill.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                System.out.println(userWaterBottle.getWaterLevelString() + '\n' + treadmill.exit() );}
                                while(currentWorkout.toLowerCase().equals("treadmill")){
                                try{
                                currentWorkout = (String) menu.getUserInputCLI();
                                }
                                catch(ClassCastException cce){
                                    System.out.println("Please don't enter a number: " + '\n');
                            }}


                            }else{
                                System.out.println("Please enter a positive value: " + '\n');

                            }

                    }catch (ClassCastException cce){

                            System.out.print("Please only enter a numerical value. " + '\n');
                        }
                        }}
                        else{
                        System.out.println(treadmill.mphHelp());
                    }
                }
                catch (ClassCastException cce){
                    System.out.print("Please only enter a numerical value. " + '\n');
                }
            //Stair Machine Workout
            }}
            if(currentWorkout.toLowerCase().equals("stair machine")&& userWaterBottle.getWaterLevel()>0){
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
                                        stairMachine.workout();
                                        person.setLowerBodyLevel(1);
                                        if(person.getLowerBodyLevel()>=6){
                                            System.out.println("Oh no! You over worked your lower body and had to leave!");
                                            currentWorkout = "leave";
                                        }else{
                                        sweatBank.setCaloriesSweatOut((int) stairMachine.getCaloriesBurned());
                                        gymLog.log((int)stairMachine.getStepsPerMinute() + " SPM", (int)stairMachine.getMinutes() + " minutes ",(int)stairMachine.getCaloriesBurned() + " calories burned using " + stairMachine.getName(),sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                        userWaterBottle.drinkWater();
                                        System.out.println('\n'+"You burned "+ (int) stairMachine.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                        System.out.println(userWaterBottle.getWaterLevelString() + '\n' + stairMachine.exit() );}
                                        while(currentWorkout.toLowerCase().equals("stair machine")){
                                        try {
                                            currentWorkout = (String) menu.getUserInputCLI();
                                        } catch (ClassCastException cce) {
                                            System.out.println("Please don't enter a number: " + '\n');
                                        }}
                                    } else {
                                        System.out.println("Please enter a positive value: "+ '\n');

                                    }
                                } catch (ClassCastException cce) {
                                    System.out.print("Please only enter a numerical value. "+ '\n');
                                }
                            }
                        } else {
                            System.out.println(stairMachine.sphHelp());
                        }

                    } catch (ClassCastException cce) {
                        System.out.print("Please only enter a numerical value. "+ '\n');
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
                                        pushUps.workout();
                                        person.setCoreLevel(1);
                                        if(person.getCoreLevel()>=6){
                                            System.out.println("Oh no! You over worked your core and had to leave!");
                                            currentWorkout = "leave";
                                        }else{
                                        sweatBank.setCaloriesSweatOut((int)pushUps.getCaloriesBurned());
                                        gymLog.log((int) pushUps.getAmountOfSets() + " Sets of " + (int)pushUps.getAmountPerSet() ,  " There are no minute restrictions. ",(int) pushUps.getCaloriesBurned() + " calories burned doing " + pushUps.getName() + " ",sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                        userWaterBottle.drinkWater();
                                        System.out.println('\n'+"You burned "+ (int) pushUps.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                        System.out.println(userWaterBottle.getWaterLevelString() + '\n' + pushUps.exit() );}
                                        while(currentWorkout.toLowerCase().equals("pushups")){
                                            try{
                                                currentWorkout = (String) menu.getUserInputCLI();
                                            }
                                            catch(ClassCastException cce){
                                                System.out.println("Please don't enter a number: "+ '\n');
                                            }}


                                    }else{
                                        System.out.println("Please enter a positive value: "+ '\n');

                                    }

                                }catch (ClassCastException cce){
                                    System.out.print("Please only enter a numerical value. "+ '\n');
                                }
                            }}
                        else{
                            System.out.println("Please enter a positive value: "+ '\n');
                        }
                    }
                    catch (ClassCastException cce){
                        System.out.print("Please only enter a numerical value. "+ '\n');
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
                                                System.out.println(squats.minutesInput());
                                                numberInput = (double) menu.getUserInputCLI();
                                                if(squats.setMinutesValid(numberInput)){
                                                    squats.setMinutes( numberInput);
                                                    squats.workout();
                                                    person.setLowerBodyLevel(1);
                                                    if(person.getLowerBodyLevel()>=6){
                                                        System.out.println("Oh no! You over worked your lower body and had to leave!");
                                                        currentWorkout = "leave";
                                                    }else{
                                                    sweatBank.setCaloriesSweatOut((int)squats.getCaloriesBurned());
                                                    gymLog.log((int)squats.getAmountOfSets() + " Sets of " + (int)squats.getAmountPerSet(), squats.getMinutes() + " minutes ",(int)squats.getCaloriesBurned() + " calories burned doing " + squats.getName() + " ", sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                                    userWaterBottle.drinkWater();
                                                    System.out.println('\n'+"You burned "+ (int) squats.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                                    System.out.println(userWaterBottle.getWaterLevelString() + '\n' + squats.exit() );}
                                                    while(currentWorkout.toLowerCase().equals("squats")){
                                                        try{
                                                            currentWorkout = (String) menu.getUserInputCLI();
                                                        }
                                                        catch(ClassCastException cce){
                                                            System.out.println("Please don't enter a number: "+ '\n');
                                                        }}}
                                                    else{
                                                     System.out.println("Please enter a positive value: "+ '\n');
                                         }}catch (ClassCastException cce){
                                                System.out.print("Please only enter a numerical value. "+ '\n');
                                            }}
                                        }


                                    else{
                                        System.out.println("Please enter a positive value: "+ '\n');

                                    }

                                }catch (ClassCastException cce){
                                    System.out.print("Please only enter a numerical value. "+ '\n');
                                }
                            }}
                        else{
                            System.out.println("Please enter a positive value: "+ '\n');
                        }
                    }
                    catch (ClassCastException cce){
                        System.out.print("Please only enter a numerical value. "+ '\n');
                    }
                }}
            //Lunges
            if(currentWorkout.toLowerCase().equals("lunges") && userWaterBottle.getWaterLevel()>0){
                System.out.println( lunges.getWalkUp());
                while(currentWorkout.toLowerCase().equals("lunges")){
                    try{
                        System.out.println(lunges.amountPerSetInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if(lunges.setAPSValid( numberInput)){
                            lunges.setAmountPerSet(numberInput);
                            while(currentWorkout.toLowerCase().equals("lunges")){
                                try{
                                    System.out.println(lunges.amountOfSetInput());
                                    numberInput = (double) menu.getUserInputCLI();
                                    if(lunges.setAOSValid(numberInput)){
                                        lunges.setAmountOfSets( numberInput);
                                        while(currentWorkout.toLowerCase().equals("lunges")){
                                            try{
                                                System.out.println(lunges.minutesInput());
                                                numberInput = (double) menu.getUserInputCLI();
                                                if(lunges.setMinutesValid(numberInput)){
                                                    lunges.setMinutes( numberInput);
                                                    lunges.workout();
                                                    person.setLowerBodyLevel(1);
                                                    if(person.getLowerBodyLevel()>=6){
                                                        System.out.println("Oh no! You over worked your lower body and had to leave!");
                                                        currentWorkout = "leave";
                                                    }else{
                                                    sweatBank.setCaloriesSweatOut((int)lunges.getCaloriesBurned());
                                                    gymLog.log((int)lunges.getAmountOfSets() + " Sets of " + (int)lunges.getAmountPerSet(), " for " +(int)lunges.getMinutes() + " minutes ",(int) lunges.getCaloriesBurned() + " calories burned doing  " + lunges.getName() + " ",sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                                    userWaterBottle.drinkWater();
                                                    System.out.println('\n'+"You burned "+ (int) lunges.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                                    System.out.println(userWaterBottle.getWaterLevelString() + '\n' + lunges.exit() );}
                                                    while(currentWorkout.toLowerCase().equals("lunges")){
                                                        try{
                                                            currentWorkout = (String) menu.getUserInputCLI();
                                                        }
                                                        catch(ClassCastException cce){
                                                            System.out.println("Please don't enter a number: "+ '\n');
                                                        }}}
                                                else{
                                                    System.out.println("Please enter a positive value: "+ '\n');
                                                }}catch (ClassCastException cce){
                                                System.out.print("Please only enter a numerical value. "+ '\n');
                                            }}
                                    }


                                    else{
                                        System.out.println("Please enter a positive value: "+ '\n');

                                    }

                                }catch (ClassCastException cce){
                                    System.out.print("Please only enter a numerical value. "+ '\n');
                                }
                            }}
                        else{
                            System.out.println("Please enter a positive value: "+ '\n');
                        }
                    }
                    catch (ClassCastException cce){
                        System.out.print("Please only enter a numerical value. "+ '\n');
                    }
                }}


            //Mirror Selfie
            if(currentWorkout.toLowerCase().equals("mirror selfie") && userWaterBottle.getWaterLevel()>0){
                System.out.println( mirrorSelfie.getWalkUp());
                person.mentalBoost();
                gymLog.log("1 picture taken ", "in no time! ","No calories were burned but " + person.getName() + " burned ",sweatBank.getCaloriesSweatOut() + " total calories" );
                while(currentWorkout.toLowerCase().equals("mirror selfie")){
                    try{
                        currentWorkout = (String) menu.getUserInputCLI();
                    }
                    catch(ClassCastException cce){
                        System.out.println("Please don't enter a number: "+ '\n');
                    }
            }}
            //Asking For Help
            if(currentWorkout.toLowerCase().equals("help")){
                System.out.println("Please enter one of the below options or say leave: " + '\n');
                    for (Exercise exercise : exercises) {
                        System.out.println(exercise.getName());
                    }
                    while(currentWorkout.toLowerCase().equals("help")) {
                    try{
                    currentWorkout = (String) menu.getUserInputCLI();}
                    catch(ClassCastException cce){
                        System.out.println("Please don't enter a number: " + '\n');
                    }
                }
            }
            //Need to Fill Water
            if(userWaterBottle.getWaterLevel()==0 || currentWorkout.toLowerCase().equals("fill water") ){
                boolean filled = false;
                if(currentWorkout.toLowerCase().equals("fill water")){
                    System.out.println(userWaterBottle.fillWater());
                    System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                    try{
                    currentWorkout = (String) menu.getUserInputCLI();
                    filled = true;}
                    catch(ClassCastException cce){
                        System.out.println("Please don't enter a number: " + '\n');
                    }
                }else{
                System.out.print("Please type Fill Water to continue your workout: ");
                while(!filled){
                    waterInput = "";
                    try{
                    waterInput =(String) menu.getUserInputCLI();}
                    catch (ClassCastException cce) {
                        System.out.println("Please don't enter a number: "+ '\n');
                    }while(!filled){
                        if (waterInput.toLowerCase().equals("leave")) {
                            System.out.println("Thanks for coming to Eric's Gym! ");
                            System.exit(1);
                        } else if (waterInput.toLowerCase().equals("fill water")) {
                            System.out.println( userWaterBottle.fillWater());
                            System.out.println("What workout would you like to start with? Say HELP to see available workouts. ");
                            currentWorkout = (String) menu.getUserInputCLI();
                            filled = true;
                        }else {
                            System.out.println("Please fill your water bottle");
                            try{
                                waterInput = (String) menu.getUserInputCLI();}
                            catch(ClassCastException cce){
                                System.out.println("Please don't enter a number: "+ '\n');
                            }
                             }}
            }}}
            //Plank
            if(currentWorkout.toLowerCase().equals("planks") && userWaterBottle.getWaterLevel()>0) {
                System.out.println(plank.getWalkUp());
                while (currentWorkout.toLowerCase().equals("planks")) {
                    try {
                        System.out.println(plank.minuteInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if (plank.setMinutesValid(numberInput)) {
                            plank.setMinutes(numberInput);
                            plank.workout();
                            person.setCoreLevel(1);
                            if(person.getCoreLevel()>=6){
                                System.out.println("Oh no! You over worked your core and had to leave!");
                                currentWorkout = "leave";
                            }else{
                            userWaterBottle.drinkWater();
                            sweatBank.setCaloriesSweatOut((int) plank.getCaloriesBurned());
                            gymLog.log("Planks arent rep'd based. " + person.getName() + " did ", plank.getMinutes() + " minutes ",(int)plank.getCaloriesBurned() + " calories burned doing " + plank.getName() + " ",sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                            System.out.println('\n' + "You burned " + (int) plank.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! ");
                            System.out.println(userWaterBottle.getWaterLevelString() + '\n' + plank.exit());}
                            while (currentWorkout.toLowerCase().equals("planks")) {
                                try {
                                    currentWorkout = (String) menu.getUserInputCLI();
                                } catch (ClassCastException cce) {
                                    System.out.println("Please don't enter a number: " + '\n');
                                }
                            }
                        } else {
                            System.out.println("Please enter a positive value: " + '\n');
                        }
                    } catch (ClassCastException cce) {
                        System.out.print("Please only enter a numerical value. " + '\n');
                    }
                }
            }
            //Bench
            if(currentWorkout.toLowerCase().equals("bench") && userWaterBottle.getWaterLevel()>0){
                System.out.println( bench.getWalkUp());
                while(currentWorkout.toLowerCase().equals("bench")){
                    try{
                        System.out.println(bench.amountPerSetInput());
                        numberInput = (double) menu.getUserInputCLI();
                        if(bench.setAPSValid( numberInput)){
                            bench.setAmountPerSet(numberInput);
                            while(currentWorkout.toLowerCase().equals("bench")){
                                try{
                                    System.out.println(bench.amountOfSetInput());
                                    numberInput = (double) menu.getUserInputCLI();
                                    if(bench.setAOSValid(numberInput)){
                                        bench.setAmountOfSets( numberInput);
                                        while(currentWorkout.toLowerCase().equals("bench")){
                                            try{
                                                System.out.println(bench.minuteInput());
                                                numberInput = (double) menu.getUserInputCLI();
                                                if(bench.setMinutesValid(numberInput)){
                                                    bench.setMinutes( numberInput);
                                                    bench.workout();
                                                    person.setUpperBodyLevel(1);
                                                    if(person.getUpperBodyLevel()>=6){
                                                        System.out.println("Oh no! You over worked your upper body and had to leave!");
                                                        currentWorkout = "leave";
                                                    }else{
                                                        sweatBank.setCaloriesSweatOut((int)bench.getCaloriesBurned());
                                                        gymLog.log((int)bench.getAmountOfSets() + " Sets of " + (int)bench.getAmountPerSet(), bench.getMinutes() + " minutes ",(int)bench.getCaloriesBurned() + " calories burned using " + bench.getName(),sweatBank.getCaloriesSweatOut() + " total calories burned by " + person.getName() );
                                                        userWaterBottle.drinkWater();
                                                        System.out.println('\n'+"You burned "+ (int) bench.getCaloriesBurned() + " calories! Your total calories burned are now " + sweatBank.getCaloriesSweatOut() + "! "  );
                                                        System.out.println(userWaterBottle.getWaterLevelString() + '\n' + bench.exit() );}
                                                    while(currentWorkout.toLowerCase().equals("bench")){
                                                        try{
                                                            currentWorkout = (String) menu.getUserInputCLI();
                                                        }
                                                        catch(ClassCastException cce){
                                                            System.out.println("Please don't enter a number: "+ '\n');
                                                        }}}
                                                else{
                                                    System.out.println("Please enter a positive value: "+ '\n');
                                                }}catch (ClassCastException cce){
                                                System.out.print("Please only enter a numerical value. "+ '\n');
                                            }}
                                    }


                                    else{
                                        System.out.println("Please enter a positive value: "+ '\n');

                                    }

                                }catch (ClassCastException cce){
                                    System.out.print("Please only enter a numerical value. "+ '\n');
                                }
                            }}
                        else{
                            System.out.println("Please enter a positive value: "+ '\n');
                        }
                    }
                    catch (ClassCastException cce){
                        System.out.print("Please only enter a numerical value. "+ '\n');
                    }
                }}


            //Leave
            if (currentWorkout.toLowerCase().equals("leave")) {
                System.out.println("Thanks for coming to Eric's Gym! ");
                System.out.println( person.getName()+  " you did amazing! Your total workout burned " + sweatBank.getCaloriesSweatOut() + " calories!");
                gymLog.closeLog();
                System.exit(1);
            }

            //Not Valid input
            else if (!currentWorkout.toLowerCase().equals("bench") && !currentWorkout.toLowerCase().equals("lunges") && !currentWorkout.toLowerCase().equals("mirror selfie") && !currentWorkout.toLowerCase().equals("planks")&&!currentWorkout.toLowerCase().equals("pushups") && !currentWorkout.toLowerCase().equals("squats") && !currentWorkout.toLowerCase().equals("stair machine") && !currentWorkout.toLowerCase().equals("treadmill") && !currentWorkout.toLowerCase().equals("fill water") && !currentWorkout.toLowerCase().equals("help") && !currentWorkout.toLowerCase().equals("leave")) {
                System.out.println("Please enter an exercise, help or leave: ");
                try{
                currentWorkout = (String) menu.getUserInputCLI();}
                catch(ClassCastException cce){
                    System.out.println("Please don't enter a number: "+ '\n');
                }
            }
    }}
    public static void main(String[] args) {
        //Attempt Number 2
        Menu menu = new Menu(System.in, System.out);
        EricsGym eg = new EricsGym(menu);
        eg.run();
    }}