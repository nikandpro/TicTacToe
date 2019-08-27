package com.github.tos.Interface;


import com.github.tos.Interface.Game;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox modalpanel = new VBox();
        HBox modalpanel2 = new HBox();
        Text text = new Text("Первый или второй решать тебе!!!");
        text.setFont(new Font(20));
        modalpanel.setAlignment(Pos.BASELINE_CENTER);
        HBox.setMargin(modalpanel2, new Insets(70));

        modalpanel.getChildren().addAll(text, modalpanel2);

        Button zero = new Button("Первый");
        Button cross = new Button("Второй");
        zero.setFont(new Font(20));
        cross.setFont(new Font(20));
        modalpanel2.setAlignment(Pos.CENTER);
        HBox.setMargin(zero, new Insets(50));
        HBox.setMargin(cross, new Insets(50));
        modalpanel2.getChildren().addAll(zero, cross);

        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game game = new Game();
                Game.courseSelection=true;
                game.modalGame();
            }
        });
        cross.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Game game = new Game();
                Game.courseSelection=false;
                game.modalGame();
            }
        });


        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(modalpanel, 400, 200));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
