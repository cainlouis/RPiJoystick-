package com.mycompany.rpijoystick;

import java.util.List;

/**
 *
 * @author Nael Louis 
 */
public class ProcessBuilder {
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
    
    public java.lang.ProcessBuilder getProcessBuilder() {
        return this.processBuilder;
    }
}
