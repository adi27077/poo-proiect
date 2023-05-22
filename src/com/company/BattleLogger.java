package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BattleLogger implements Logger{
    private static BattleLogger instance;
    private String outputFile;
    private boolean logToSout = true;
    private boolean logToFile = true;

    private BattleLogger() {
    }

    public static BattleLogger getInstance() {
        if(instance == null)
            instance = new BattleLogger();
        return instance;
    }

    public void newLog(String fileName, int logNo) {
        outputFile = fileName;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Battle Log " + logNo + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String logText) {
        if(logToSout)
            System.out.println(logText);
        if(logToFile) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
                bw.write(logText);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLogToSout(boolean logToSout) {
        this.logToSout = logToSout;
    }

    public void setLogToFile(boolean logToFile) {
        this.logToFile = logToFile;
    }
}
