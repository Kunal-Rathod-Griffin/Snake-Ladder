package com.example.snl;

import javafx.fxml.FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class HelloController {



    @FXML
    private Button Dice;

    @FXML
    private ImageView diceImage;

    @FXML
    private ImageView gameBoard;

    @FXML
    private GridPane gameGrid;

    Player player1;
    Player player2;
    gameBoard snl;
    Dice mydice;

    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private Pane scene1;

    Piece pic1;

    public void tester()
    {

    }

    public void OnClickingDice(MouseEvent mouseEvent) {
//        int count =9;
//        int count2 = 8;
//        ImageView temp_image = p1;
//
//        gameGrid.getChildren().remove(p1);
////        if(count == 10){
////            count2--;
////            count = 9;
////        }
//
//        gameGrid.add(temp_image, count , count2);
//        count++;


        snl.moveThePlayer();

//        ObservableList<Node> node = gameGrid.getChildren();
//
//        Node a=  node.get(19);
//
//        System.out.println(a.getLayoutX() + " " + a.getLayoutY());

//        gameGrid.add(p1, 9, 8);


    }


    public void initialize()
    {

        Dice = new Button();
        player1 = new Player(1, p1, 1);
        player2 = new Player(2, p2, 0);

        mydice = new Dice();
        mydice.setBt(Dice);

        snl = new gameBoard(player1, player2, gameGrid, mydice);



    }

}

class gameBoard extends  Thread{



    Dice dice;

    Label num_label;
    Player player1;
    Player player2;

    private final Snake nagini;
    private final Ladder ladder;

    GridPane gameGrid;

    int curren_player;

    gameBoard(Player p1, Player p2, GridPane grid, Dice dice)
    {
        this.dice = dice;
        this.gameGrid = grid;
        this.player1 = p1;
        this.player2 = p2;

        player1.setTurn(1);
        player2.setTurn(0);

        nagini = new Snake();
        ladder = new Ladder();

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
        }
        else if(current_player == 2)
        {
            player1.setTurn(1);
            player2.setTurn(0);
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

    public int rollTheDice() {
        final int low = 1;
        final int high = 6;

        return new Random().nextInt((high - low) + 1) + low;
    }

    public void moveThePlayer()
    {
        System.out.println("--------------------------------------------------------");
        //8+6 = 14 m// 14/10 == 1 // 30-14 = 16
        //19 + 5 = 24 // 24/10 == 2 // 23

        curren_player = selectThePlayer();  //this will look into turn function and will decide the player

        //whose_turn == 1 => player 1
        //              2 => player 2

        System.out.println("current player: " + curren_player);
        int dice_num = rollTheDice();

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


                return;
            }
            else{
                swap_players(curren_player);
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

            dice.getBt().setDisable(true);
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
                return;
            }
        }

//        try {
//            Thread.sleep( 5000);
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



        System.out.println("this is image id: "+ img.getId());
        gameGrid.getChildren().remove(img);
        gameGrid.add(img, column_number, row_number);

    }

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

    Player(int id,  ImageView imagee, int turn)
    {
        this.id = id;
        my_pic = new Piece(imagee);
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

    Piece(ImageView image)
    {
        this.my_image = image;
        position = -1;
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
