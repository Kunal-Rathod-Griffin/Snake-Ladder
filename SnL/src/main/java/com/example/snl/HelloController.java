package com.example.snl;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;


import java.util.HashMap;

public class HelloController {


    @FXML
    private Button Dice;

    @FXML
    private ImageView diceImage;

    @FXML
    private ImageView gameBoard;

    @FXML
    private GridPane gameGrid;


    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private Pane scene1;

    public void tester()
    {

    }



    public void OnClickingDice(MouseEvent mouseEvent) {

//        ObservableList<Node> a = gameGrid.getChildren();
//        Node temp = a.get(50);
//        double x = temp.getTranslateX();
//        double y = temp.getTranslateY();
//        System.out.println("x: " + x + " y: " + y);



        p1.setX(50);
        p1.setY(100);

    }

    public void initialize()
    {
        Dice = new Button();

    }

}

class gameBoard{

/*
1. dice the roll
2. change the player
3. move the player
4. decide the winner
 */

    public void selectThePlayer()
    {

    }
    public void rollTheDice()
    {

    }
    public void moveThePlayer()
    {
    }


    public void changeThePlayer()
    {

    }


}


class Player{
/*
1. id
2. piece
3. Turn if(1 = turn , -1 = no turn)
 */

    private  int id;
    private Piece p;
    private int turn;


}

class Piece{

/*
0. button
1. position
2. color
3. Image
 */

    private Button token;
    private int position;
    private ImageView image;


}

class Snake{
/*
1. Hashmap
2. will check if it's a neck of a snake
 */
    HashMap<Integer, Integer> snake = new HashMap<Integer, Integer>();

    public void isNeck()
    {

    }
}

class Ladder{
/*
1. Hashmap
2. will check if it's a start of a ladder
 */
    HashMap<Integer, Integer> ladder = new HashMap<Integer, Integer>();
}

class Dice{
/*
0. Buttun
1. Images (animation of a rolling dice)
2. Rolling the dice
3. disable or enable dice
 */

    private Button bt;
    private Box dice;

    public void rollTheDice()
    {

    }

    public void disableTheDice()
    {

    }

    public void enableTheDice()
    {

    }
}
