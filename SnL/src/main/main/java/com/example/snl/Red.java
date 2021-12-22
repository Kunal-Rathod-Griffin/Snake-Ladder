package com.example.snl;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Red {

    @FXML
    private ImageView back2;

    @FXML
    private ImageView menu2;

    @FXML
    private ImageView play2;


    @FXML
    void onBack(MouseEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newGame.fxml" ));
        Parent root = loader.load();

        Scene scene2 = new Scene(root);

        GameStart ccc = loader.getController();


        Stage stage2;
        stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();

    }

    @FXML
    void onNext(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BlueGreen.fxml" ));
        Parent root = loader.load();

        Scene scene2 = new Scene(root);

        Blue ccc = loader.getController();


        Stage stage2;
        stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();
    }

    @FXML
    void onPlay(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hello-view.fxml" ));
        Parent root = loader.load();

        Scene scene2 = new Scene(root);

        HelloController ccc = loader.getController();
        ccc.theColor(2);

        Stage stage2;
        stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();

    }


}
