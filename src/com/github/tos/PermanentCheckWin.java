package com.github.tos;

import com.github.tos.Processing.Memory;
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


public class PermanentCheckWin {

    private final static int[] variable = {0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6};


    public static void checkOnWin(int numberButton, Stage window, boolean humanOrProcessing) {
        Memory.record(numberButton);
        if (Memory.numberMove<9) {
            isLooking(window , humanOrProcessing);
        } else {
            win(window, "DRAW");
        }
    }


    private static void isLooking(Stage window, boolean humanOrProcessing) {
        int i=0;
        while ( i<24) {
            if (Memory.rewriting.contains(variable[i]) && Memory.rewriting.contains(variable[i+1]) && Memory.rewriting.contains(variable[i+2])) {
                if (humanOrProcessing) {
                    isLookingZero(window, "WIN_PLAYER", variable[i], variable[i+1], variable[i+2]);
                } else {
                    isLookingZero(window, "WIN_PC", variable[i], variable[i+1], variable[i+2]);
                }
            }
            i=i+3;
        }
    }

    static void isLookingZero(Stage window, String status, int cell1, int cell2, int cell3) {
        if (Memory.rewritingZeroOrCross[cell1]==Memory.rewritingZeroOrCross[cell2] && Memory.rewritingZeroOrCross[cell2]==Memory.rewritingZeroOrCross[cell3]) {
            win(window, status);
        }
    }

    private static void win(Stage window, String status) {
        Stage window2 = new Stage();
        window2.initModality(Modality.APPLICATION_MODAL);
        VBox pane = new VBox();
        Text cooWin = new Text();
        Button exit = new Button("Exit");

        pane.setAlignment(Pos.BASELINE_CENTER);

        Memory.win=true;
        cooWin.setText(status);
        cooWin.setFont(new Font(20));

        VBox.setMargin(exit, new Insets(50));
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window2.close();
                window.close();
            }
        });

        pane.getChildren().addAll(cooWin, exit);
        Scene scene = new Scene(pane, 200, 200);
        window2.setScene(scene);
        window2.setTitle("Play");
        window2.show();
    }
}

