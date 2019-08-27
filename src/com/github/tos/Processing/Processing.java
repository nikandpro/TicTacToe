package com.github.tos.Processing;

import com.github.tos.Controller;
import com.github.tos.Interface.Game;
import com.github.tos.Interface.ResultAnnouncements;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Processing {

    private final static int[] variable = {0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6};
    public static boolean end=false;


    public static void searchInMemory(Stage window, ArrayList<Button> buttonList) {
        int number=ThreadLocalRandom.current().nextInt(0,9);
        while (Memory.rewriting.contains(number)) {
            number=ThreadLocalRandom.current().nextInt(0,9);
        }

        Controller.insertImage(number, buttonList);
        checkOnWin(number, window, false);
        Game.courseSelection = true;
    }

    //public static int piensa() { //it's in spanish

    //}

    public static void checkOnWin(int numberButton, Stage window, boolean humanOrProcessing) {
        Memory.record(numberButton);
        if (Memory.numberMove<9) {
            isLooking(window , humanOrProcessing);
        } else {
            isLooking(window , humanOrProcessing);
            if (!end) {
                ResultAnnouncements.win(window, "DRAW");
            }
        }
        System.out.println(Memory.currentArray);
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
            ResultAnnouncements.win(window, status);
        }
    }



}
