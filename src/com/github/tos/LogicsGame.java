package com.github.tos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LogicsGame {
    //static ArrayList checkBoard = new ArrayList(9);
    static  int[] checkBoard = new int[] {3,4,5,6,7,8,9,10,11};

    static void checkWin() {
        if (checkBoard[0]==checkBoard[1] && checkBoard[1]==checkBoard[2]) win(checkBoard[0]);
        else if (checkBoard[3]==checkBoard[4] && checkBoard[4]==checkBoard[5]) win(checkBoard[3]);
        else if (checkBoard[6]==checkBoard[7] && checkBoard[7]==checkBoard[8]) win(checkBoard[6]);
        else if (checkBoard[0]==checkBoard[3] && checkBoard[3]==checkBoard[6]) win(checkBoard[0]);
        else if (checkBoard[1]==checkBoard[4] && checkBoard[4]==checkBoard[7]) win(checkBoard[1]);
        else if (checkBoard[2]==checkBoard[5] && checkBoard[5]==checkBoard[8]) win(checkBoard[2]);
        else if (checkBoard[0]==checkBoard[4] && checkBoard[4]==checkBoard[8]) win(checkBoard[0]);
        else if (checkBoard[2]==checkBoard[4] && checkBoard[4]==checkBoard[6]) win(checkBoard[2]);

    }


    static void win(int simvol) {
        Stage window2 = new Stage();
        window2.initModality(Modality.APPLICATION_MODAL);
        VBox pane = new VBox();
        Text cooWin = new Text();
        Button exit = new Button("Exit");

        pane.setAlignment(Pos.BASELINE_CENTER);

        if (simvol==2) cooWin.setText("WIN 1 player");
        else cooWin.setText("WIN 2 player");
        cooWin.setFont(new Font(20));

        VBox.setMargin(exit, new Insets(50));
        exit.setOnAction(event -> window2.close());

        pane.getChildren().addAll(cooWin, exit);
        Scene scene = new Scene(pane , 200, 200);
        window2.setScene(scene);
        window2.setTitle("Play");
        window2.show();
    }
}
