package com.github.tos;

import com.github.tos.Processing.Processing;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game {

    ArrayList<Button> buttonList = new ArrayList<>();
    public static boolean courseSelection;
    //contains information about who walks: user or Processing

    private void layoutPieces() {
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());
        buttonList.add(new Button());

    }

    public void modalGame() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Controller.window=window;

        GridPane root = new GridPane();

        layoutPieces();

        for (int i=0; i<9; i++) {
            buttonList.get(i).setMaxWidth(Double.MAX_VALUE);
            buttonList.get(i).setMaxHeight(Double.MAX_VALUE);
            GridPane.setHgrow(buttonList.get(i), Priority.ALWAYS);
            GridPane.setVgrow(buttonList.get(i), Priority.ALWAYS);
            GridPane.setMargin(buttonList.get(i), new Insets(5));
        }

        Button close = new Button("close");
        GridPane.setMargin(close, new Insets(10));
        close.setFont(new Font(20));

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(100);
        root.getColumnConstraints().add(column1);
        root.getColumnConstraints().add(column1);
        root.getColumnConstraints().add(column1);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        root.getRowConstraints().add(row1);
        root.getRowConstraints().add(row1);
        root.getRowConstraints().add(row1);

        for (int i=0, n=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                root.add(buttonList.get(n),j ,i);
                n++;
            }
        }

        if (!courseSelection) {
            Processing.searchInMemory(window, buttonList);
        }

        for (int i=0; i<9; i++) {
            int finalI = i;
            buttonList.get(i).setOnAction(event -> Controller.initialize(finalI, buttonList));
        }

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controller.firstsimbol=true;
                window.close();
            }
        });

        root.add(close, 1, 3);

        Scene scene = new Scene(root, 300, 400);
        window.setScene(scene);
        window.setTitle("Play");
        window.show();
    }





}

