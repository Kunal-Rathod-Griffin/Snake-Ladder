package com.example.snl;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
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

public class HelloController {

    @FXML
    private Button Dice;

    @FXML
    private Box boxx;

    @FXML
    private ImageView diceImage;

    @FXML
    private ImageView gameBoard;

    @FXML
    private GridPane gameGrid;
    @FXML
    private ImageView player1_img;

    @FXML
    private ImageView player2_img;

    Player player1;
    Player player2;
    gameBoard snl;
    Dice mydice;
    DiceAnimation dd;
    @FXML
    private ImageView p1;

    @FXML
    private ImageView arrow;

    @FXML
    private ImageView p2;

    @FXML
    private Pane scene1;

    Piece pic1;

//    public void tester() throws FileNotFoundException {
//        PhongMaterial material = new PhongMaterial();
//        Image image2 = new Image(new FileInputStream("D:\\Sem_3\\AP\\animations\\src\\main\\resources\\com\\example\\animations\\five.png"));
//        material.setDiffuseMap(image2);
//        boxx.setMaterial(material);
//
//        RotateTransition rotate2 = new RotateTransition();
//
//        rotate2.setNode(boxx);
//        rotate2.setDuration(Duration.millis(400));
//        rotate2.setCycleCount(2);
//        rotate2.setInterpolator(Interpolator.LINEAR);
//
//        Point3D pp = new Point3D(1,1,1);
//        rotate2.setAxis(pp);
//        rotate2.setByAngle(360);
//        rotate2.play();
//
//        ScaleTransition scale = new ScaleTransition();
//
//        scale.setNode(boxx);
//        scale.setDuration(Duration.millis(400));
//        scale.setAutoReverse(true);
//        scale.setCycleCount(2);
//        scale.setInterpolator(Interpolator.LINEAR);
//        scale.setToX(2);
//        scale.setToY(2);
//        scale.setToZ(2);
//
//        scale.play();
//
//
//    }



    DiceAnimation roll;
    public void OnClickingDice(MouseEvent mouseEvent) throws IOException {

        roll.rockAndRoll(boxx);

//        PauseTransition pause = new PauseTransition(Duration.seconds(3));

        System.out.println("enterfing move the player");
        final int low = 1;
        final int high = 6;

        int fin_num = new Random().nextInt((high - low) + 1) + low;

        PhongMaterial material = new PhongMaterial();
//        Image image2 = new Image(new FileInputStream("D:\\Sem_3\\AP\\animations\\src\\main\\resources\\com\\example\\animations\\five.png"));
//        ImageView image2 = new ImageView(imges.get(fin_num - 1));


        FileInputStream input;
        Image img;

        if(fin_num == 1)
        {
            input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\one.png");
             img = new Image(input);
            material.setDiffuseMap(img);
        }
        if(fin_num == 2)
        {
            input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\two.png");
            img = new Image(input);
            material.setDiffuseMap(img);
        }
        if(fin_num == 3)
        {
            input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\three.png");
            img = new Image(input);
            material.setDiffuseMap(img);
        }
        if(fin_num == 4)
        {
            input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\four.png");
            img = new Image(input);
            material.setDiffuseMap(img);
        }if(fin_num == 5)
        {
            input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\five.png");
            img = new Image(input);
            material.setDiffuseMap(img);
        }if(fin_num == 6)
        {
            input = new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\six.png");
            img = new Image(input);
            material.setDiffuseMap(img);
        }

        boxx.setMaterial(material);
//        Timeline timeline = new Timeline(
//                new KeyFrame(
//                        Duration.seconds(1)
////                        event -> {
////                            i.set(i.get() + 1);
////                            label.setText("Elapsed time: " + i.get() + " seconds");
////                        }
//                )
//        );
//        timeline.setCycleCount(2);
//        timeline.play();

        snl.moveThePlayer(fin_num);
        if(snl.GameOver == true)
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ending.fxml" ));
            Parent root = loader.load();

            Scene scene2 = new Scene(root);

            Controller2  ccc = loader.getController();
            ccc.receiveTheWinner(snl.curren_player);

            Stage stage2;
            stage2 = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage2.setScene(scene2);
            stage2.show();
        }

        roll.translate.play();


    }

    @FXML
    void rollingDice(MouseEvent event) throws FileNotFoundException {

//        roll.rockAndRoll(boxx);

//        PhongMaterial material = new PhongMaterial();
//        Image image2 = new Image(new FileInputStream("D:\\Sem_3\\AP\\animations\\src\\main\\resources\\com\\example\\animations\\five.png"));
//        material.setDiffuseMap(image2);
//        boxx.setMaterial(material);

//        tester();


//        Platform.runLater(new animation(boxx));



    }
//    ArrayList<Image> imges;
//    public void setImages()
//    {
//
//
//        Image img1 = new Image("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\one.jpg");
//        Image img2 = new Image("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\two.jpg");
//        Image img3 = new Image("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\three.jpg");
//        Image img4 = new Image("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\four.jpg");
//        Image img5 = new Image("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\five.png");
//        Image img6 = new Image("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\six.jpg");
//        imges.add(0, img1);
//        imges.add(1, img2);
//        imges.add(2, img3);
//        imges.add(3, img4);
//        imges.add(4, img5);
//        imges.add(5, img6);
//
//
//    }

    public void initialize() throws FileNotFoundException {


//        roll = new DiceAnimation();


//        tester();

//        PhongMaterial material = new PhongMaterial();
//        Image image2 = new Image(new FileInputStream("D:\\Sem_3\\AP\\animations\\src\\main\\resources\\com\\example\\animations\\five.png"));
//        material.setDiffuseMap(image2);
//        boxx.setMaterial(material);
//        void roll(ActionEvent event) {
//
//
//            rollButton.setDisable(true);
//
//            Thread thread = new Thread() {
//                public void run() {
//                    System.out.println("Thread Running");
//                    try {
//                        for (int i = 0; i < 15; i++) {
//                            int number = (random.nextInt(6) + 1);
//                            Image dImage = new Image(getClass().getResourceAsStream("D" + number + ".jpeg"));
//                            diceImage.setImage(dImage);
//                            Thread.sleep(500);
//                            num = number;
//
//                        }
//                        rollButton.setDisable(false);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//
//            thread.start();
//
//
//        }

        roll = new DiceAnimation( arrow );
        PhongMaterial material = new PhongMaterial();
        Image image2 = new Image(new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\six.png"));
        material.setDiffuseMap(image2);
        boxx.setMaterial(material);
//        imges = new ArrayList<>() ;


        ColorAdjust asd = new ColorAdjust();
        asd.setBrightness(-0.64);
        player2_img.setEffect(asd);

        Dice = new Button();
        player1 = new Player(1, p1,player1_img ,1);
        player2 = new Player(2, p2, player2_img,0);
        mydice = new Dice();
        mydice.setBt(Dice);

        snl = new gameBoard(player1, player2, gameGrid, mydice, Dice, arrow);

    }

//    public void glow_image()
//    {
//        int turn = snl.curren_player;
//
//        if(turn == 1)
//        {
//            ColorAdjust dark = new ColorAdjust();
//            dark.setBrightness(-0.64);
//            player2_img.setEffect(dark);
//
//            ColorAdjust dark1 = new ColorAdjust();
//            dark1.setBrightness(0);
//            player1_img.setEffect(dark1);
//        }
//        else {
//            ColorAdjust dark = new ColorAdjust();
//            dark.setBrightness(-0.64);
//            player1_img.setEffect(dark);
//
//            ColorAdjust dark1 = new ColorAdjust();
//            dark1.setBrightness(0);
//            player2_img.setEffect(dark1);
//        }
//    }
}

class DiceAnimation
{
    ImageView arrow;
    DiceAnimation(ImageView arrow)
    {
        this.arrow = arrow;
        arrowPointing();
    }
    TranslateTransition translate;
    public void rockAndRoll(Box boxx)
    {

        translate.stop();
        RotateTransition rotate2 = new RotateTransition();

        rotate2.setNode(boxx);
        rotate2.setDuration(Duration.millis(333));
        rotate2.setCycleCount(3);
        rotate2.setInterpolator(Interpolator.LINEAR);

        Point3D pp = new Point3D(1,1,1);
        rotate2.setAxis(pp);
        rotate2.setByAngle(360);
        rotate2.play();

        ScaleTransition scale = new ScaleTransition();

        scale.setNode(boxx);
        scale.setDuration(Duration.millis(500));
        scale.setAutoReverse(true);
        scale.setCycleCount(2);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setToX(1.3);
        scale.setToY(1.3);
        scale.setToZ(1.3);

        scale.play();




//        scale.play();

    }

    public void arrowPointing()
    {
         translate = new TranslateTransition();

        translate.setNode(arrow);
        translate.setCycleCount(TranslateTransition.INDEFINITE);
//        translate.setByY(20);
        translate.setFromY(5);
        translate.setToY(25);
        translate.setAutoReverse(true);
        translate.setDuration(Duration.millis(500));


    }
}



//class animation implements  Runnable{
//
//    Box boxx;
//
//    animation(Box box)
//    {
//        this.boxx = box;
//
//
//    }
//
//    @Override
//    public void run() {
//
//        System.out.println("am i in run???-------------------------------------------");
//        RotateTransition rotate2 = new RotateTransition();
//
//
//        rotate2.setNode(boxx);
//        rotate2.setDuration(Duration.millis(400));
//        rotate2.setCycleCount(2);
//        rotate2.setInterpolator(Interpolator.LINEAR);
//
//        Point3D pp = new Point3D(1,1,1);
//        rotate2.setAxis(pp);
//        rotate2.setByAngle(360);
//        rotate2.play();
//
//        ScaleTransition scale = new ScaleTransition();
//
//        scale.setNode(boxx);
//        scale.setDuration(Duration.millis(400));
//        scale.setAutoReverse(true);
//        scale.setCycleCount(2);
//        scale.setInterpolator(Interpolator.LINEAR);
//        scale.setToX(2);
//        scale.setToY(2);
//        scale.setToZ(2);
//
//        scale.play();
//
//        System.out.println("am i reacing the end -----------------------------------------");
//    }
//}

class run1 implements Runnable{

    GridPane gameGrid;
    ImageView img;
    int column_number, row_number;
    run1(GridPane grid, ImageView img, int column_number, int row_number){
        this.gameGrid = grid;
        this.img = img;
        this.column_number = column_number;
        this.row_number = row_number;
    }

    @Override
    public void run(){
        try {
            Thread.sleep( 1000);

        } catch (InterruptedException ie) {
            System.out.println("here");
            Thread.currentThread().interrupt();
        }
        System.out.println("this is image id1: "+ img.getId());
        gameGrid.getChildren().remove(img);
        gameGrid.add(img, column_number, row_number);
    }
}



class gameBoard  {

    Button my_button;
    Dice dice;
    boolean GameOver;
    int Winner;
    Label num_label;
    Player player1;
    Player player2;
    ImageView arrow;
    private final Snake nagini;
    private final Ladder ladder;
//    TranslateTransition translate;
    GridPane gameGrid;

    int curren_player;



    gameBoard(Player p1, Player p2, GridPane grid, Dice dice, Button bt, ImageView arrow)
    {

        this.my_button = bt;
        this.dice = dice;
        this.gameGrid = grid;
        this.player1 = p1;
        this.player2 = p2;
        this.arrow = arrow;

        player1.setTurn(1);
        player2.setTurn(0);

        nagini = new Snake();
        ladder = new Ladder();
        Winner = -1;
//        translate = new TranslateTransition();
//
//        translate.setNode(arrow);
//        translate.setCycleCount(TranslateTransition.INDEFINITE);
////        translate.setByY(20);
//        translate.setFromY(5);
//        translate.setToY(25);
//        translate.setAutoReverse(true);
//        translate.setDuration(Duration.millis(500));
//        translate.play();




    }

/*
1. dice the roll
2. change the player
3. move the player
4. decide the winner
 */



    public int selectThePlayer()
    {
        if(player1.getTurn() == 1)
        {
            return player1.getId();
        }
        else{
            return player2.getId();
        }


        //highlighty the player
        //return the player id
    }

    public void swap_players(int current_player)
    {
        if(current_player == 1)
        {
            player1.setTurn(0);
            player2.setTurn(1);

            ColorAdjust dark = new ColorAdjust();
            dark.setBrightness(0);
            player2.getMy_pic().getPlayer1_img().setEffect(dark);

            ColorAdjust dark2 = new ColorAdjust();
            dark2.setBrightness(-0.64);
            player1.getMy_pic().getPlayer1_img().setEffect(dark2);


        }
        else if(current_player == 2)
        {

            player1.setTurn(1);
            player2.setTurn(0);
            ColorAdjust dark = new ColorAdjust();
            dark.setBrightness(0);
            player1.getMy_pic().getPlayer1_img().setEffect(dark);
            ColorAdjust dark2 = new ColorAdjust();
            dark2.setBrightness(-0.64);
            player2.getMy_pic().getPlayer1_img().setEffect(dark2);

        }

    }

    public void set_Position_of_Player(int position)
    {
        if(curren_player == 1)
        {
            player1.getMy_pic().setPosition(position);
        }
        else if(curren_player == 2)
        {
            player2.getMy_pic().setPosition(position);
        }
    }

    public void diceAnimation()
    {

    }

//    public int rollTheDice() throws FileNotFoundException {
//
//
//
//
//        final int low = 1;
//        final int high = 6;
//
//        int fin_num = new Random().nextInt((high - low) + 1) + low;
//        ImageView img = new ImageView(imges.get(fin_num - 1));
////
////        System.out.println("am i here setting an image");
//        dice.getBt().setGraphic(img);
////        dice.getBt().setText("kunal");
////        System.out.println("Id of the button: " +  dice.getBt().getId());
//
////        System.out.println("Lets see id of this: " +  my_button.getId());
////        System.out.println("now see the id: " );
//
//        return fin_num;
//    }

    public void moveThePlayer(int rand_num) throws IOException {

//        int m =0;
//        for(int i =0; i< 100000; i++)
//        {
//            m++;
//        }

//        translate.stop();

//        try{
//            Thread.sleep(1000);
//        }catch (Exception e)
//        {
//
//        }

        System.out.println("am i rolling the dice animati9ona");
        DiceAnimation roll;
//        roll = new DiceAnimation();
//        PhongMaterial material = new PhongMaterial();
//
//        Image image2 = new Image(new FileInputStream("D:\\Sem_3\\AP\\SnL\\src\\main\\resources\\com\\example\\snl\\five.png"));
//
//        material.setDiffuseMap(image2);
//        boxx.setMaterial(material);


        System.out.println("--------------------------------------------------------");
        //8+6 = 14 m// 14/10 == 1 // 30-14 = 16
        //19 + 5 = 24 // 24/10 == 2 // 23

        curren_player = selectThePlayer();  //this will look into turn function and will decide the player

        //whose_turn == 1 => player 1
        //              2 => player 2

        System.out.println("current player: " + curren_player);
        int dice_num = rand_num;

        System.out.println("This is dice_num: " + dice_num);
//        diceAnimation();

        int curr_position = -1;
        if(curren_player == 1)
        {

            curr_position =  player1.getMy_pic().getPosition();
        }
        else if(curren_player == 2)
        {

            curr_position =  player2.getMy_pic().getPosition();
        }

        System.out.println("this is current postition: " + curr_position);
        if(curr_position == -1)
        {
            if(dice_num == 1)
            {
                moveTheImage(0 , 9);
                set_Position_of_Player(1);
                swap_players(curren_player);

//                translate.play();
                return;
            }
            else{
                swap_players(curren_player);
//                translate.play();
                return;
            }
        }

        System.out.println("current position after swapping: " + curr_position);

        //the position on the player will we according to the game board



        //updated position = 16
//        ObservableList<Node> node = gameGrid.getChildren();
//        Node new_pane =  node.get(16);

        //now we got the update position 16
        //now we have to find the row and column index to add the image there from this 16
        int new_position = curr_position + dice_num;  // 8 + 6 = 14 (according to the board which is 16 according to the grid)

        if(new_position > 100)
        {
            swap_players(curren_player);
            return;
        }
        if(new_position == 100)
        {
            set_Position_of_Player(new_position);
            int[] coordinates =  getRowsAndColumn(new_position); //so this will take 16 and return (6 column, 8 row)

            System.out.println("Y : " + coordinates[0] + "  X: "+ coordinates[1] );
            //now we will add the image at this coordinates using move the image
            moveTheImage(coordinates[1], coordinates[0]);

            GameOver = true;
            Winner = curren_player;
//            dice.getBt().setDisable(true);

        }

        System.out.println("this is new_position: " + new_position);

        //******************// we will have to check the corner cases
        set_Position_of_Player(new_position);


        int[] coordinates =  getRowsAndColumn(new_position); //so this will take 16 and return (6 column, 8 row)

        System.out.println("Y : " + coordinates[0] + "  X: "+ coordinates[1] );
        //now we will add the image at this coordinates using move the image



        moveTheImage(coordinates[1], coordinates[0]);

        //so now the image is at 16
        //16 = (6 col, 8 row)

        //now we will check if it's a snakes mouth or ladder end

//        int new_grid_position = boradToGrid(new_position); //
        int went_down =  nagini.isHead( new_position ); //


        int went_up = -1;
//        went_down == -1


        if(went_down == -1) {
            //when the new position is not the neck
             went_up = ladder.isLowerEnd(new_position);

            if (went_up == -1) {
                //when the new position is also not the ladder
                //in this case we simply change the turns of the players
                swap_players(curren_player);
//                translate.play();
                return;
            }
        }


//        try {
//            Thread.sleep( 1000);
//
//        } catch (InterruptedException ie) {
//            System.out.println("here");
//            Thread.currentThread().interrupt();
//        }


        System.out.println("did you reach here????????????????");
        //if either snake or ladder was there at the new position
        //Now isHead() and isLoweEnd() functions will decide the fate of our token

        //so these functions will return the updated postions according to the grid. the hashtable is according the grid
        //but new_position is board's position and we are not calculating grid position
        //we will use boardToGrid function to get the updated position
        //we will enter that grid postion in this snake and ladder

        //snake has map of grid postions so now we have updated grid postion
        //but we will need to update the board postion of a piece so we need fucntion of gridToBoard()

        int new_position_after = -1;
        if(went_down != -1)
        {
            new_position_after = went_down;
        }
        else if(went_up != -1)
        {
            new_position_after = went_up;
        }

        //now we will have to do some of the above functions again

//        int new_board_position_after = curr_position + dice_num;  // 8 + 6 = 14 (according to the board which is 16 according to the grid)

        set_Position_of_Player(new_position_after);

        int[] new_coordinates =  getRowsAndColumn(new_position_after); //so this will take 16 and return (6 column, 8 row)

        //now we will add the image at this coordinates using move the image
        moveTheImage(new_coordinates[1], new_coordinates[0]);
        swap_players(curren_player);

        //after doing snake or ladder there wont be another snake or ladder so now we just updated the position

        //And the end

//        if(curr_position == -1)
//        {
//            if(dice_num == 1)
//            {
//                dice.getBt().setText(String.valueOf(dice_num));
//
//                ImageView img = player1.getMy_pic().getMy_image();
//
//
////                System.out.println("this is image id: "+ img.getId());
//                gameGrid.getChildren().remove(img);
//                gameGrid.add(img, 0, 9);
//
//            }
//        }
//        translate.play();
    }

    public int gridToBoard(int grid_position)
    {
        int r = grid_position/10;
        int c = grid_position%10;
        int board_pos=-1;
        if(r%2==0){
            board_pos = grid_position+1;
        }
        else if(r%2==1 && c!=0){
            int tot = 2*(r*10) + 10;
            board_pos = tot-grid_position;
        }
        else if(r%2==1 && c==0){
            int tot = (r*10) + (r+1)*10;
            board_pos = tot-grid_position;
        }
        //this will take 16 and return 14
        //algo
        return board_pos;
    }

    public int boradToGrid(int board_position)
    {
//        HashMap<Integer, Integer> lg = new HashMap<>();
//        lg.put(1,1);

        int r = board_position/10;
        int c = board_position%10;
        int grid_pos=-1;
        if(r%2==0 && c!=0){
            grid_pos = board_position-1;
        }
        else if(r%2==1 && c==0){
            grid_pos = board_position-1;
        }
        else if(r%2==1 && c!=0){
            int tot = 2*(r*10) + 10;
            grid_pos = tot-board_position;
        }
        else if(r%2==0 && c==0){
            int tot = (r*10) + (r-1)*10;
            grid_pos = tot-board_position;
        }
        //this will take 14 and return 16
        //update the image on screen
        //update piece position
        // onboard = 14; ongrid = 16

        return grid_pos;
    }

    public int[] getRowsAndColumn(int updated_position)
    {
        int grid_pos = boradToGrid(updated_position);
        int r= grid_pos/10;
        int row = 9-r;
        int col= grid_pos%10;

        int[] a = new int[2];
        a[0] = row;
        a[1] = col;
        return a;


    }


//    public int[] getRowsAndColumn(int updated_position)
//    {
//
//
//        int position_acc_to_gird = boradToGrid(updated_position);
//
//        //16
//
//        int[] a = new int[2];
//        return a;
//    }

//    public int gridToBoard(int grid_position)
//    {
//        //this will take 16 and return 14
//        //algo
//        return 0;
//    }
//
//    public int boradToGrid(int board_position)
//    {
//
//        //this will take 14 and return 16
//        //update the image on screen
//        //update piece position
//        // onboard = 14; ongrid = 16
//
//        return -1;
//    }
public void moveTheImage(int column_number, int row_number)
{
    //we will need to check the current player for this
    //we've got to make the current player globla for this class
    ImageView img = null;
    if(curren_player == 1)
    {
        img = player1.getMy_pic().getMy_image();
    }
    else if(curren_player == 2)
    {
        img = player2.getMy_pic().getMy_image();

    }

//        Platform.runLater(new run1(gameGrid, img, column_number, row_number));

    System.out.println("this is image id: "+ img.getId());
    gameGrid.getChildren().remove(img);
    gameGrid.add(img, column_number, row_number);

}

    public void moveTheImage2(int column_number, int row_number)
    {
        //we will need to check the current player for this
        //we've got to make the current player globla for this class
        ImageView img = null;
        if(curren_player == 1)
        {
            img = player1.getMy_pic().getMy_image();
        }
        else if(curren_player == 2)
        {
            img = player2.getMy_pic().getMy_image();

        }

        Platform.runLater(new run1(gameGrid, img, column_number, row_number));

//        System.out.println("this is image id: "+ img.getId());
//        gameGrid.getChildren().remove(img);
//        gameGrid.add(img, column_number, row_number);

    }
//    public void moveTheImage(int column_number, int row_number)
//    {
//        //we will need to check the current player for this
//        //we've got to make the current player globla for this class
//        ImageView img = null;
//        if(curren_player == 1)
//        {
//            img = player1.getMy_pic().getMy_image();
//        }
//        else if(curren_player == 2)
//        {
//            img = player2.getMy_pic().getMy_image();
//
//        }
//
//
//
//        System.out.println("this is image id: "+ img.getId());
//        gameGrid.getChildren().remove(img);
//        gameGrid.add(img, column_number, row_number);
//
//    }

//    public void changeThePlayer()
//    {
//
//    }


}

class Player{
/*
1. id
2. piece
3. Turn if(1 = turn , -1 = no turn)
 */
    private  int id;
    private Piece my_pic;
    private int turn;

    public Piece getMy_pic() {
        return my_pic;
    }

    public void setMy_pic(Piece my_pic) {
        this.my_pic = my_pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTurn(int i)
    {
        this.turn = i;
    }

    public int getTurn()
    {
        return this.turn;
    }

    Player(int id,  ImageView imagee, ImageView player1_img ,int turn)
    {
        this.id = id;
        my_pic = new Piece(imagee, player1_img);
        this.turn = turn;
    }

}

class Piece{

/*
0. button
1. position
2. color
3. Image
 */

//    private Button token;
    private int position;
    private ImageView my_image;
    private  ImageView player1_img;

    Piece(ImageView image, ImageView player1_img)
    {
        this.player1_img = player1_img;
        this.my_image = image;
        position = -1;
    }


    public ImageView getPlayer1_img()
    {
        return  this.player1_img;
    }

    public void setPlayer1_img( ImageView player1_img)
    {
        this.player1_img = player1_img;
    }

    public ImageView getMy_image() {
        return my_image;
    }

    public void setMy_image(ImageView my_image) {
        this.my_image = my_image;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

class Snake{
/*
1. Hashmap
2. will check if it's a neck of a snake
 */
    HashMap<Integer, Integer> map;
//    snake.put(1,2);

    public Snake()
    {
        map = new HashMap<>();
        map.put(11,9);
        map.put(36,14);
        map.put(56,18);
        map.put(43,22);
        map.put(90,50);
        map.put(94,53);
        map.put(75,54);
        map.put(96,65);
        map.put(99,78);
        map.put(81, 63);

    }




    public int isHead(int curr_position)
    {

        System.out.println("current head: " + curr_position);



        Set<Integer> set = map.keySet();
        for(Integer k : set)
        {
            if(curr_position == k)
            {
                int return_item = map.get(k);

                return return_item;
            }
        }
        return  -1;
    }


}

class Ladder{
/*
1. Hashmap
2. will check if it's a start of a ladder
 */
    private HashMap<Integer, Integer> ladder;
    public Ladder()
    {
        ladder = new HashMap<>();
        ladder.put(8,31);
        ladder.put(4,25);
        ladder.put(28, 46);
        ladder.put(32,48);
        ladder.put(21, 60);
        ladder.put(42,80);
        ladder.put(58,77);
        ladder.put(52, 68);
        ladder.put(69, 93);
        ladder.put(84, 98);
    }

    public int isLowerEnd( int curr_position)
    {
        //-1 is not the lower end
        //else return the updated position

        Set<Integer> set = ladder.keySet();
        for(Integer k : set)
        {
            if(curr_position == k)
            {
                int return_item = ladder.get(k);

                return return_item;
            }
        }

        return  -1;
    }

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


    public void setBt(Button bt) {
        this.bt = bt;

    }

    public Button getBt() {
        return bt;
    }

    public void setDice(Box dice) {
        this.dice = dice;
    }

    public Box getDice() {
        return dice;
    }

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

 class PhoneBook {

    private HashMap<String, String> data;

    public PhoneBook()
    {
        data = new HashMap<String, String>();
    }
    public void addPhone(String name, String num)
    {
        data.put(name, num);
    }


    //a
    public String getPhone(String name){
        if(data.containsValue(name)){
            return data.get(name);
        }
        else
            return null;
    }

    //b
    public void ToString(){
        data.toString();
    }

    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();
        pb.addPhone("shlomi", "12312413yuioyuio24");
        pb.addPhone("shlomi1", "1231345345241324");
        pb.addPhone("shlomi2", "12312445735671324");
        System.out.println(pb.getPhone("shlomi"));
        System.out.println(pb.getPhone("blat"));
        pb.ToString();
    }
}
