package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Buttons
        Button btn = new Button("Click me!");
        Button btn2 = new Button("Label Button!");
        Label label = new Label("You have not pushed the button!");

        btn.setOnAction(e -> System.out.println("Test button"));
        btn2.setOnAction(e -> label.setText("You have pushed the button!"));

        // Image from resources
        Image image = new Image(getClass().getResource("/bruno-morningwood.jpg").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(250);  // Slightly smaller image for the reduced window size
        imageView.setPreserveRatio(true);

        // Toggle image button
        Button toggleImage = new Button("Toggle Image");
        toggleImage.setOnAction(e -> imageView.setVisible(!imageView.isVisible()));

        // TextField input and greeting
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your name");
        Label greeting = new Label();
        Button greetButton = new Button("Greet");
        greetButton.setOnAction(e -> greeting.setText("Hello, " + nameInput.getText() + "!"));

        // Checkbox
        CheckBox rockMode = new CheckBox("Enable Rock Mode");
        rockMode.setOnAction(e -> System.out.println("Rock Mode: " + rockMode.isSelected()));

        // Radio Buttons
        ToggleGroup difficultyGroup = new ToggleGroup();
        RadioButton easy = new RadioButton("Easy");
        RadioButton hard = new RadioButton("Hard");
        easy.setToggleGroup(difficultyGroup);
        hard.setToggleGroup(difficultyGroup);

        Button difficultyCheck = new Button("Check Difficulty");
        difficultyCheck.setOnAction(e -> {
            RadioButton selected = (RadioButton) difficultyGroup.getSelectedToggle();
            if (selected != null) {
                System.out.println("Selected difficulty: " + selected.getText());
            }
        });

        // ComboBox
        ComboBox<String> genreBox = new ComboBox<>();
        genreBox.getItems().addAll("Rock", "Metal", "Blues");
        genreBox.setOnAction(e -> System.out.println("Selected genre: " + genreBox.getValue()));

        // Slider
        Slider volumeSlider = new Slider(0, 100, 50);
        volumeSlider.valueProperty().addListener((obs, oldVal, newVal) ->
            System.out.println("Volume: " + newVal.intValue())
        );

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: lightgray;");

        layout.getChildren().addAll(
            btn, btn2, label,
            toggleImage, imageView,
            nameInput, greetButton, greeting,
            rockMode,
            easy, hard, difficultyCheck,
            genreBox,
            volumeSlider
        );

        // Smaller scene
        Scene scene = new Scene(layout, 600, 700);
        stage.setTitle("JavaFX App Full Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
