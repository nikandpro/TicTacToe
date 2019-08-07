package com.github.tos;

import com.github.tos.Processing.Memory;
import com.github.tos.Processing.Processing;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;


public class Controller  {

    static Stage window;

    public static boolean firstsimbol;


    public static void initialize(int numberButton, ArrayList<Button> buttonList) {

        insertImage(numberButton, buttonList);

        PermanentCheckWin.checkOnWin(numberButton, window, true);

        if (Memory.numberMove<8 && Game.courseSelection && Memory.win==false) {
            Processing.searchInMemory(window, buttonList);
        }

    }

    public static void insertImage( int numberButton, ArrayList<Button> buttonList) {
        InputStream input = Controller.class.getResourceAsStream("/com/github/tos/icon/i2.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        InputStream input2 = Controller.class.getResourceAsStream("/com/github/tos/icon/i1.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);

        if (firstsimbol) {
            buttonList.get(numberButton).setGraphic(imageView);
        } else buttonList.get(numberButton).setGraphic(imageView2);
        firstsimbol = !firstsimbol;
    }
}
