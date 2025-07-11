package apka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MAIN extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a button
        Button btn = new Button("Say Hello");
        btn.setOnAction(e -> System.out.println("Hello, JavaFX!"));

        // Set up the layout
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Create a scene with the layout and set it on the stage
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("JavaFX Test");
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}