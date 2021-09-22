package com.mycompany.rpijoystick;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.Tile.SkinType;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.Tile.ImageMask;
import eu.hansolo.tilesfx.Tile.TextSize;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import javafx.scene.layout.HBox;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Nael Louis <your.name at your.org>
 */
public class Dashboard extends HBox {
    //Constructor
    public Dashboard() throws IOException {
        this.buildScreen();
    }
    
    private void buildScreen() throws IOException {
        //var local = new Local("en", "CA");
        
        //Tile for clock 
        var clockTile = TileBuilder.create()
                .skinType(SkinType.CLOCK)
                .prefSize(350, 300)
                .title("Date & Time")
                .dateVisible(true)
                .locale(Locale.CANADA)
                .running(true)
                .build();
                
                /*Tile for choiceBox */
                
        //ChoiceBox and it's values
        ChoiceBox choiceBox = new ChoiceBox();
        
        choiceBox.getItems().add("All output in TextArea");
        choiceBox.getItems().add("One output at a time");
        
        //Label for the choiceBox
        Label options = new Label("Select your choice: ");
        options.setTextFill(Color.WHITE);
        
        //Hbox for the choiceBox
        HBox cbBox = new HBox(choiceBox);
        
        FlowPane fp = new FlowPane(options, cbBox);
        
        choiceBox.setOnAction((event) -> {
            //to do:
        });
        
        var choiceTile = TileBuilder.create()
                .skinType(SkinType.CUSTOM)
                .prefSize(350, 300)
                .textSize(TextSize.BIGGER)
                .graphic(fp)
                .build();
                
                /*Tile for exit button*/
                
        //Create button and event handler
        Button exit = new Button("Exit");
        exit.setOnAction((event) -> {
            endApplication();
        });
        
        //Tile 
        var exitTile = TileBuilder.create()
                .skinType(SkinType.CUSTOM)
                .prefSize(350, 300)
                .textSize(TextSize.BIGGER)
                .title("Do you want to quit?")
                .graphic(exit)
                .build();
                    
                /*TextArea tile for X axis and timestamp */
            
        TextArea xAxis = new TextArea();
        xAxis.setEditable(false);
        
        //layout of the textArea
        VBox xAxisBox = new VBox(xAxis);
        
        //Tile
        var xAxisTextAreaTile = TileBuilder.create()
                .skinType(SkinType.CUSTOM)
                .prefSize(350, 300)
                .title("TextArea for x axis and timestamp")
                .graphic(xAxisBox)
                .build();
        
                /*TextArea tile for Y axis and timestamp */
        
        TextArea yAxis = new TextArea();
        yAxis.setEditable(false);
        
        //layout of the textArea
        VBox yAxisBox = new VBox(yAxis);
        
        //Tile
        var yAxisTextAreaTile = TileBuilder.create()
                .skinType(SkinType.CUSTOM)
                .prefSize(350, 300)
                .title("TextArea for y axis and timestamp")
                .graphic(yAxisBox)
                .build();
        
                /*TextArea tile for Z axis and timestamp */
        
        TextArea zAxis = new TextArea();
        zAxis.setEditable(false);
        
        //layout of the textArea
        VBox zAxisBox = new VBox(zAxis);
        
        //Tile
        var zAxisTextAreaTile = TileBuilder.create()
                .skinType(SkinType.CUSTOM)
                .prefSize(350, 300)
                .title("TextArea for z axis and timestamp")
                .graphic(zAxisBox)
                .build();
        
        //Add tiles to Hbox
        HBox row1 = new HBox(clockTile, choiceTile, exitTile);
        row1.setMinWidth(350);
        row1.setSpacing(5);
        
        HBox row2 = new HBox(xAxisTextAreaTile, yAxisTextAreaTile, zAxisTextAreaTile);
        row2.setMinWidth(350);
        row2.setSpacing(5);
        
        VBox allTiles = new VBox(row1, row2);
        allTiles.setSpacing(5);
        
        //Add rows to root
        this.getChildren().add(allTiles);
    }
    
    private void endApplication() {
        Platform.exit();
    }
}
