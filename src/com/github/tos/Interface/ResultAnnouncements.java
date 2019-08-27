package com.github.tos.Interface;

import com.github.tos.Controller;
import com.github.tos.Processing.Memory;
import com.github.tos.Processing.Processing;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ResultAnnouncements {

    public static void win(Stage window, String status) {
        Stage window2 = new Stage();
        window2.initModality(Modality.APPLICATION_MODAL);
        VBox pane = new VBox();
        Text cooWin = new Text();
        Button exit = new Button("Exit");

        pane.setAlignment(Pos.BASELINE_CENTER);

        Memory.win=true;
        cooWin.setText(status);
        cooWin.setFont(new Font(20));

        Processing.end=true;

        VBox.setMargin(exit, new Insets(50));
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window2.close();
                window.close();
                Controller.firstsimbol=true;
                Memory.rewriting.clear();
                Memory.win=false;
                Memory.numberMove=0;
                Memory.currentArray="";
                //conclusionMap();
                Processing.end=false;
            }
        });

        pane.getChildren().addAll(cooWin, exit);
        Scene scene = new Scene(pane, 200, 200);
        window2.setScene(scene);
        window2.setTitle("Play");
        window2.show();
    }

    public static void conclusionMap() { //array"Map" output
        for (Object key: Memory.arrayGame.keySet()) {
        System.out.print("\t"+key);
        }
    }
}

