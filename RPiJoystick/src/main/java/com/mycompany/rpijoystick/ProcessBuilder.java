package com.mycompany.rpijoystick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Nael Louis <your.name at your.org>
 */
public class ProcessBuilder {
    //Stores the output from the process
    private String theOutput;
    
    private java.lang.ProcessBuilder processBuilder;
    
   //The constructor to execute Python command takes a String
    public ProcessBuilder(String theApp) {
        this.processBuilder = new java.lang.ProcessBuilder();
   
        //Determine if the OS is MS Windows 
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        
        //List to store the command and the command arguments
        List<String> commandAndArgs;
        
        //Setup the command based on the OS type
        if (isWindows) {
            commandAndArgs = List.of("C:\\Dev\\sudo", theApp);
            this.processBuilder.command(commandAndArgs);
        }
        else {
            commandAndArgs = List.of("/usr/bin/sudo", theApp);
            this.processBuilder.command(commandAndArgs);
        }
    }
    
    
    //Start the process and get the output
    String startProcess() throws IOException {
       
        //Initialize theOutput to null String
        this.theOutput = "";
        
        //Start the process
        var process = this.processBuilder.start();
        
        try (var reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()))) {

            String line = reader.readLine();
            this.theOutput = line;
        }
        return this.theOutput;
    }
    
    public java.lang.ProcessBuilder getProcessBuilder() {
        return this.processBuilder;
    }
}
