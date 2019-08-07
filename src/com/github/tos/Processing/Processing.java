package com.github.tos.Processing;

import com.github.tos.Controller;
import com.github.tos.Game;
import com.github.tos.PermanentCheckWin;
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

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Processing {


    public static void searchInMemory(Stage window, ArrayList<Button> buttonList) {
        int numberButton = ThreadLocalRandom.current().nextInt(0, 9);
        while (Memory.rewriting.contains(numberButton)) {
            numberButton = ThreadLocalRandom.current().nextInt(0, 9);
        }

        Controller.insertImage(numberButton, buttonList);
        PermanentCheckWin.checkOnWin(numberButton, window, false);
        Game.courseSelection = true;
    }

}
