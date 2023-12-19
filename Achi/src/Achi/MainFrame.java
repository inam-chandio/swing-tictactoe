package Achi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Achi.Achi.*;
import static Achi.Box.*;

class MainFrame extends JFrame {

    static void update_text_panel(){
        player_x_score.setText(player_x.name + " Score: "+ player_x.score);
        player_o_score.setText(player_o.name + " Score: "+ player_o.score);
        current_player_label.setText("Current Player: " + current_player.name);
        current_player_label.setForeground(current_player.symbol == CELL.X ? Color.red : Color.blue);
    }

    // constructor
    public MainFrame() {
        setTitle("Tic Tac Toe");
        setSize(900, 900);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);


        // create game board
        board = new GameBoard();
        board.setBounds(0, 100, 900, 600);
        add(board);
        board.revalidate();
        board.setVisible(false);

        add(text_panel);
        add(text_panel2);
        add(button_panel);

        start_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start_button.setSelected(false);
                start_button.setFocusable(false);
                start();
            }
        });

        reset_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset_button.setSelected(false);
                reset_button.setFocusable(false);
                reset();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    start();
                }
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    reset();
                }
            }
        });
    }

    static void start(){
        update_text_panel();
        board.emptyBoxes();
        board.setVisible(true);
        if(!(isWinner)) {
            String playerName = current_player == player_x ? player_x.name : player_o.name;
            JOptionPane.showMessageDialog(null, playerName + "'s move", "Move", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static void reset(){
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to reset the game?","Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            player_x.score = 0;
            player_o.score = 0;
            update_text_panel();
            board.emptyBoxes();
            board.setVisible(false);
        }
    }
}
