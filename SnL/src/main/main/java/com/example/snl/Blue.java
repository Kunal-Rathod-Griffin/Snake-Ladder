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

public class Blue {

    @FXML
    private ImageView back1;

    @FXML
    private ImageView menu1;

    @FXML
    private ImageView play1;

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
        loader.setLocation(getClass().getResource("RedYellow.fxml" ));
        Parent root = loader.load();

        Scene scene2 = new Scene(root);

        Red ccc = loader.getController();


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
        ccc.theColor(1);

        Stage stage2;
        stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage2.setScene(scene2);
        stage2.show();

    }

}
