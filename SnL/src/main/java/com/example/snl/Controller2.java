package com.example.snl;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;


public class Controller2 {

    @FXML
    private ImageView win;

    public void receiveTheWinner(int n) throws FileNotFoundException {
        if(n == 1)
        {
            FileInputStream input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\win1.png");
            Image img2 = new Image(input);
            win.setImage(img2);
        }
        else if(n == 2)
        {
            FileInputStream input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\win2e.png");
            Image img2 = new Image(input);
            win.setImage(img2);
        }
    }


    @FXML
    void endTheGame(MouseEvent event) {
        System.exit(0);

    }
    


}
