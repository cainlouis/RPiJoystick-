package com.mycompany.rpijoystick;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author Zacharie Makeen
 */
public class ProcessBuilderTest {
    
    public ProcessBuilder processInstance;
    
    public ProcessBuilderTest() {
        String theCmd = "./Joystick";
        processInstance = new ProcessBuilder(theCmd);
    }

    /**
     * Test of getProcessBuilder method, of class ProcessBuilder.
     */
    @Test
    public void testGetProcessBuilder() {
        System.out.println("getProcessBuilder");
        java.lang.ProcessBuilder result = processInstance.getProcessBuilder();
        assertNotNull(result);
    }
    
}
    
