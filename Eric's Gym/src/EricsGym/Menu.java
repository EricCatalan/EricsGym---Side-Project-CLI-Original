package EricsGym;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
    private PrintWriter out;
    private Scanner in;
    public boolean isADouble = false;
    private Double validDoubleInput ;
    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public boolean isADouble() {
        return isADouble;
    }

    public Menu (InputStream input, OutputStream output){
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Object getUserInputCLI (){
        Object choice = null;
        userInput = in.nextLine();
        try{
            choice = Double.valueOf(userInput);
            isADouble = true;

        }catch (NumberFormatException nfe){

        }
        if (choice == null){
            choice = userInput;
        }
       return choice;
        }
    }

