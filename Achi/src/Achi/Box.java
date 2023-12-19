package Achi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Achi.Achi.*;
import static Achi.MainFrame.*;

class Box extends JPanel implements MouseListener {
    CELL state = CELL.EMPTY;
    JLabel label;

    static Boolean isWinner = false;

    // constructor
    public Box(int row, int col) {
        setBackground(Color.WHITE);
        setSize(100, 100);
        setLayout(new GridBagLayout());
        setBounds(col * 100, row *100, 100, 100);
        setBorder(BorderFactory.createLineBorder(BLACK));
        addMouseListener(this);
        label = new JLabel();
        label.setText("");
        label.setFont(new Font("Consolas", Font.PLAIN, 30));
        add(label);
    }

    public void clear(){
        state = CELL.EMPTY;
        setBackground(Color.WHITE);
    }

    // mouse listener for each box
    public void mouseClicked(MouseEvent e) {
        if (state == CELL.EMPTY) {
            if (current_player.symbol == CELL.X) {
                state = CELL.X;
                if (!board.hasWinner()) current_player = player_o;
            } else {
                state = CELL.O;
                if (!board.hasWinner()) current_player = player_x;
            }
            if(!(isWinner)) {
                String playerName = current_player == player_x ? player_x.name : player_o.name;
                JOptionPane.showMessageDialog(null, playerName + "'s move", "Move", JOptionPane.INFORMATION_MESSAGE);
            }


            if(board.hasWinner()){
                if (current_player.symbol == CELL.X){
                    isWinner = true;
                    player_x.score++;
                } else {
                    isWinner = true;
                    player_o.score++;

                }
                JOptionPane.showMessageDialog(null, current_player.name + " wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                isWinner = false;
                MainFrame.start();

            } else if (board.isFull()){
                JOptionPane.showMessageDialog(null, "It's a tie!", "Tie", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.start();
            }

            update_text_panel();

            // Check if the board is full after the move, and if so, start a new game
            if (board.isFull()) {
                MainFrame.start();
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        // System.out.println("mouse pressed");

    }

    public void mouseReleased(MouseEvent e) {
        // System.out.println("mouse released");
    }

    public void mouseEntered(MouseEvent e) {
        if (state == CELL.EMPTY) {
            if (current_player.symbol == CELL.X) {
                setBackground(LIGHT_RED);
            } else {
                setBackground(LIGHT_BLUE);
            }
        }
    }

    public void mouseExited(MouseEvent e) {
        if (state == CELL.EMPTY) {
            setBackground(Color.WHITE);
        }
    }
}
