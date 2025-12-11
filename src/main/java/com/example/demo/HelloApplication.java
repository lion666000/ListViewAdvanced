package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("knihy.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        BorderPane root = new BorderPane();
        stage.setTitle("Knihovník");
        stage.setScene(scene);
        stage.show();
    }
}
