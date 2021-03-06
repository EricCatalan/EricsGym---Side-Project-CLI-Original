package EricsGym.Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Logger {
    private File logFile;
    private boolean appendMode;
    private PrintWriter logWriter;

    public Logger() throws FileNotFoundException{
        this.logFile = new File ("log.txt");
        this.appendMode = true;
        this.logWriter = new PrintWriter(new FileOutputStream(logFile,appendMode));
    }

    public Logger(File logFile, boolean append) throws FileNotFoundException {
        this.logFile = logFile;
        this.appendMode = append;
        this.logWriter = new PrintWriter(new FileOutputStream(logFile,appendMode));
    }

    public void log(String reps,String minutes, String caloriesForExercise, String totalCalories ){

        logWriter.println(String.format("%s %s %s %s", reps, minutes, caloriesForExercise, totalCalories));
        logWriter.flush();
    }

    public void closeLog() {
        logWriter.close();
    }
}
