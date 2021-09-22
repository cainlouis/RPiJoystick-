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
    
    /*
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
        launch();
    }

}