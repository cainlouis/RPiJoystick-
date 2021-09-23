package com.mycompany.rpijoystick;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Platform;


/**
 * JavaFX App
 */
public class App extends Application {
    public static Stage theStage;
    
    @Override
    public void start(Stage stage) throws IOException {
        var scene = new Scene(new Dashboard(), 900, 600);
        App.theStage = stage;
        
        //Set the active scene
        theStage.setScene(scene);
        theStage.show();
        
        // Make sure the application quits completely on close
        theStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch();
    }

}