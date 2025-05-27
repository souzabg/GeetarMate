package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) {
        Button btn = new Button("Say Hello");
        btn.setOnAction(e -> System.out.println("Hello from JavaFX!"));

        VBox layout = new VBox(10, btn);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("My First JavaFX App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
