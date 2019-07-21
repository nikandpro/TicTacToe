package com.github.tos;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.InputStream;
import java.util.ArrayList;


public class Controller  {

    static boolean firstsimbol=true;
    static ArrayList board = new ArrayList();


    public static void initialize(Button button, int numberButton) {
        InputStream input = Controller.class.getResourceAsStream("/com/github/tos/icon/i2.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        InputStream input2 = Controller.class.getResourceAsStream("/com/github/tos/icon/i1.png");
        Image image2 = new Image(input2);
        ImageView imageView2 = new ImageView(image2);

        if (firstsimbol) LogicsGame.checkBoard[numberButton]=1;
        else  LogicsGame.checkBoard[numberButton]=2;

        if (!board.contains(numberButton)) {
            if (firstsimbol) {
                button.setGraphic(imageView);
            } else button.setGraphic(imageView2);
            firstsimbol = !firstsimbol;
            board.add(numberButton);
        }

        LogicsGame.checkWin();

    }

}
