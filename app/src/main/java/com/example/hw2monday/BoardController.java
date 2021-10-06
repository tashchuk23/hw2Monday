package com.example.hw2monday;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/* BoardController class
* this class handles the majority of the backend logic for
* the puzzle. It creates boards and handles moves
 */

public class BoardController {

    //constructor for class
    public BoardController(){
        buildBoard();  //generate a random board
    }

    int[][] randomBoard;  //board to hold randomized positions

    int[][] boardPositions =
            //array which holds the number of each position on the board
            //to be compared to the value of randomBoard to determine if the
            //button is in the right spot on the board
            {
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
            };


    /* isBoardComplete
    * compares the current state of the randomBoard to what the
    * true boardPositions should be
    * called in main, where title text is changed to indicate victory
    * param: none
    * return: boolean (whether board is correct)
     */
    public boolean isBoardComplete(){

        for (int r = 0; r < 4; r++){
            for (int c = 0; c < 4; c++){
                if (boardPositions[r][c] != randomBoard[r][c]){
                    return false;
                    //evaluates to false as soon as 1 button is found out of place
                }
            }
        }
        return true;  //if no buttons are out of place, board is completely solved
    }

    /* buildBoard()
     * creates a new randomBoard that decides what text the buttons
     * should have
     * param: none
     * return: none
     */
    public void buildBoard(){
        randomBoard = new int[4][4];
        ArrayList<Integer> randArrayList = new ArrayList<Integer>();
        for (int r = 1; r < 17; r++){
            randArrayList.add(r);  //adds numbers 1 through 16 to an ArrayList
        }

        for (int r = 0; r < 4; r++){
            for (int c = 0; c < 4; c++){
                int randomIndex = (int) (Math.random() * randArrayList.size());
                //generates a random index based off the current size of the arraylist
                randomBoard[r][c] = randArrayList.get(randomIndex);
                randArrayList.remove(randomIndex); //shrinks arraylist with each loop
            }
        }
    }

    /* move()
    * calls upon the 4 surrounding sides to be checked for where the blank space is
    * and switchs the array values with the first blank space found
    * param: int row, int col
    * return: void
    */
    public void move(int r, int c){

        if (checkAbove(r, c)){
            //switch the given r c with the above space's r c in randomboard
            int temp = randomBoard[r-1][c];  //hold the above spot
            randomBoard[r-1][c] = randomBoard[r][c];
            randomBoard[r][c] = temp;
        }
        else if (checkBelow(r, c)){
            //switch the given r c with the below space's r c in randomboard
            int temp = randomBoard[r+1][c];  //holds the below spot
            randomBoard[r+1][c] = randomBoard[r][c];
            randomBoard[r][c] = temp;
        }
        else if (checkLeft(r,c)){
            //switch the given r c with the left space's r c in randomboard
            int temp = randomBoard[r][c-1];  //holds the left spot
            randomBoard[r][c-1] = randomBoard[r][c];
            randomBoard[r][c] = temp;
        }
        else if (checkRight(r, c)){
            //switch the given r c with the right space's r c in randomboard
            int temp = randomBoard[r][c+1];  //holds the right spot
            randomBoard[r][c+1] = randomBoard[r][c];
            randomBoard[r][c] = temp;
        }
    }

    /* checkAbove
    * checks the button above where was clicked to see if its the blank space
     */
    public boolean checkAbove(int r, int c){
        if (r == 0){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r - 1][c] == 16;  //return whether or not space
        //above clicked button is blank (value 16)
    }

    /* checkBelow
     * checks the button below where was clicked to see if its the blank space
     */
    public boolean checkBelow(int r, int c){

        if (r == 3){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r + 1][c] == 16;  //return whether or not space
        //below clicked button is blank (value 16)
    }

    /* checkLeft
     * checks the button left of where was clicked to see if its the blank space
     */
    public boolean checkLeft(int r, int c){

        if (c == 0){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r][c - 1] == 16;  //return whether or not space
        //left of clicked button is blank (value 16)
    }

    /* checkRight
     * checks the button right of where was clicked to see if its the blank space
     */
    public boolean checkRight(int r, int c){

        if (c == 3){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r][c + 1] == 16;  //return whether or not space
        //above clicked button is blank (value 16)
    }
}



