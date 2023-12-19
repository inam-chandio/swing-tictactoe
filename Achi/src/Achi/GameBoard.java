package Achi;

import javax.swing.*;
import java.awt.*;

import static Achi.Achi.*;

class GameBoard extends JPanel {
    Achi.Box[][] boxes;
    // constructor
    public GameBoard() {
        // set the background color of the game board
        // set the size of the game board
        setLayout(null);
        setPreferredSize(new Dimension(900, 600));
        setBackground(Color.BLACK);
        // set the layout of the game board

        // create a new instances of the box class
        boxes = new Achi.Box[3][3];
        for (int i = 0; i< 3;i++){
            for (int j = 0; j< 3;j++){
                boxes[i][j] = new Achi.Box(i,j);
                boxes[i][j].setBounds(i*300,j*200,300,200);
                add(boxes[i][j]);
            }
        }
    }

    public void emptyBoxes(){
        for (int i = 0; i< 3;i++){
            for (int j = 0; j< 3;j++){
                boxes[i][j].clear();
            }
        }
    }

    public boolean hasWinner(){
        // check horizontal
        for (int i = 0; i< 3;i++){
            if (boxes[i][0].state == boxes[i][1].state && boxes[i][1].state == boxes[i][2].state && boxes[i][0].state != CELL.EMPTY){
                boxes[i][0].setBackground(LIGHT_GREEN);
                boxes[i][1].setBackground(LIGHT_GREEN);
                boxes[i][2].setBackground(LIGHT_GREEN);
                return true;
            }
        }

        // check vertical
        for (int i = 0; i< 3;i++){
            if (boxes[0][i].state == boxes[1][i].state && boxes[1][i].state == boxes[2][i].state && boxes[0][i].state != CELL.EMPTY){
                boxes[0][i].setBackground(LIGHT_GREEN);
                boxes[1][i].setBackground(LIGHT_GREEN);
                boxes[2][i].setBackground(LIGHT_GREEN);
                return true;
            }
        }

        // check diagonal
        if (boxes[0][0].state == boxes[1][1].state && boxes[1][1].state == boxes[2][2].state && boxes[0][0].state != CELL.EMPTY){
            boxes[0][0].setBackground(LIGHT_GREEN);
            boxes[1][1].setBackground(LIGHT_GREEN);
            boxes[2][2].setBackground(LIGHT_GREEN);
            return true;
        } else if (boxes[0][2].state == boxes[1][1].state && boxes[1][1].state == boxes[2][0].state && boxes[0][2].state != CELL.EMPTY){
            boxes[0][2].setBackground(LIGHT_GREEN);
            boxes[1][1].setBackground(LIGHT_GREEN);
            boxes[2][0].setBackground(LIGHT_GREEN);
            return true;
        }

        return false;
    }

    public boolean isFull(){
        for (int i = 0; i< 3;i++){
            for (int j = 0; j< 3;j++){
                if (boxes[i][j].state == Achi.CELL.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
}
