package com.example.snl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class HelloApplication extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 563, 700);
        stage.setTitle("Ludo Master");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();

        System.getProperty("javafx.runtime.version");
        launch();
    }
}