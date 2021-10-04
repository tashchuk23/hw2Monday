package com.example.hw2monday;

import android.view.View;

import java.util.ArrayList;

public class BoardController {

    public BoardController(){

        buildBoard();

    }




    int[][] randomBoard;  //board to hold randomized positions

    int[][] boardPositions =
            //array which holds the number of each position on the board
            //to be compared to the value of the button to determine if the
            //button is in the right spot on the board
            {
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
            };


    public boolean isBoardComplete(int[][]correctBoard, int[][]currentBoard){

        for (int r = 0; r < 4; r++){
            for (int c = 0; c < 4; c++){
                if (correctBoard[r][c] != currentBoard[r][c]){
                    return false;
                }
            }
        }
        //if its true, just set the background of the game to be green
        return true;
    }


    public int[][] buildBoard(){
        randomBoard = new int[4][4];
        ArrayList<Integer> randArrayList = new ArrayList<Integer>();
        for (int r = 1; r < 17; r++){
            randArrayList.add(r);
        }


        for (int r = 0; r < 4; r++){
            for (int c = 0; c < 4; c++){
                int randomIndex = (int)Math.random() * randArrayList.size();
                randomBoard[r][c] = randArrayList.get(randomIndex);
                randArrayList.remove(randomIndex);
            }
        }

        return randomBoard;
    }
    //if theres a click, check the 4 surrounding sides
    //and switch the array values with the first blank space you find
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
            int temp = randomBoard[r][c+1];  //holds the left spot
            randomBoard[r][c+1] = randomBoard[r][c];
            randomBoard[r][c] = temp;
        }
    }

    public boolean checkAbove(int r, int c){
        //randomBoard = this.randomBoard;

        if (r == 0){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r - 1][c] == 16;  //return whether or not space
        //above clicked button is blank (value 16)
    }

    public boolean checkBelow(int r, int c){
       // randomBoard = this.randomBoard;

        if (r == 3){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r + 1][c] == 16;  //return whether or not space
        //below clicked button is blank (value 16)
    }

    public boolean checkLeft(int r, int c){
       // randomBoard = this.randomBoard;

        if (c == 0){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r][c - 1] == 16;  //return whether or not space
        //left of clicked button is blank (value 16)
    }

    public boolean checkRight(int r, int c){
       // randomBoard = this.randomBoard;

        if (c == 3){ //bounds checking, return false if its top row
            return false;
        }
        return randomBoard[r][c + 1] == 16;  //return whether or not space
        //above clicked button is blank (value 16)
    }

}



