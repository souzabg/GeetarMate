package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class App extends Application {


    @Override
    public void start(Stage stage) {
        // Create a button
        Button btn = new Button("Click me!");
        Button btn2 = new Button("Label Button!");
        
        Label label = new Label("You have not pushed the button!");


        // Button click event
        btn.setOnAction(e -> System.out.println("Test button"));
        btn2.setOnAction (e -> label.setText("You have pushed the button!"));

        //Adding an image
        Image image = new Image(getClass().getResource("/bruno-morningwood.jpg").toExternalForm());
        ImageView imageview = new ImageView(image);

        //Modifying an image
        imageview.setFitWidth(300);
        imageview.setPreserveRatio(true);

        // Create a layout and add the button
        VBox layout = new VBox(10);
        layout.getChildren().addAll(imageview, btn, btn2, label);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Create a scene with the layout
        Scene scene = new Scene(layout, 1200, 800);

        // Setup the stage (window)
        stage.setTitle("Day 1 - Hello JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();  // Start the app
    }
}