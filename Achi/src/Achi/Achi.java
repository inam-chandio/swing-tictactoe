package Achi;

import javax.swing.*;
import java.awt.*;

public class Achi {
    public static enum CELL {
        EMPTY, X, O
    }

    final static Color GRAY = new Color(204, 204, 204);
    final static Color LIGHT_GRAY = new Color(242, 242, 242);
    final static Color LIGHT_GREEN = new Color(179, 255, 204);
    final static Color LIGHT_BLUE = new Color(153, 214, 255);
    final static Color LIGHT_RED = new Color(255, 204, 204);
    final static Color BLACK = new Color(51, 51, 51);

    protected static Player player_x = new Player(CELL.X);
    protected static Player player_o = new Player(CELL.O);
    protected static Player current_player = player_x;

    static GameBoard board;
    static JLabel player_x_score;
    static JLabel player_o_score;
    static JLabel current_player_label;
    static JPanel text_panel;
    static JPanel text_panel2;
    static JButton start_button;
    static JButton reset_button;
    static JPanel button_panel;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Achi game");

        // Prompt both players to input their names
        String playerXName = JOptionPane.showInputDialog(null, "Enter Player X Name:");
        String playerOName = JOptionPane.showInputDialog(null, "Enter Player O Name:");


        player_x.name = playerXName != null && !(playerXName.split(" ").length == 1)? playerXName.split(" ")[0]: playerXName;
        player_o.name = playerOName != null && !(playerOName.split(" ").length == 1)? playerOName.split(" ")[0]: playerOName;
        player_x_score = new JLabel(  player_x.name + " Score: " + player_x.score);
        player_x_score.setForeground(Color.GREEN);
        player_x_score.setFont(new Font("Arial", Font.BOLD, 15));
        player_o_score = new JLabel(  player_o.name  + " Score: "+ player_o.score);
        player_o_score.setForeground(Color.GREEN);
        player_o_score.setFont(new Font("Arial", Font.BOLD, 15));
        current_player_label = new JLabel("Current Player: " + current_player.name);
        current_player_label.setForeground(current_player.symbol == CELL.X ? Color.red : Color.blue);
        current_player_label.setFont(new Font("Arial", Font.BOLD, 15));
        text_panel = new JPanel(new GridLayout(1, 2));
        text_panel.setBackground(Color.BLUE);
        text_panel.add(player_x_score);
        text_panel.add(player_o_score);
        text_panel.setBounds(0, 10, 900, 50);
        text_panel2 = new JPanel(new GridLayout(1, 1));
        text_panel2.add(text_panel);
        text_panel2.add(current_player_label);
        text_panel2.setBounds(0, 60, 900, 20);
        start_button = new JButton("Start (SPACE)");
        start_button.setBounds(0, 0, 900 / 2, 20);
        reset_button = new JButton("Reset (R)");
        reset_button.setBounds(900 / 2, 0, 900 / 2, 20);
        button_panel = new JPanel(new GridLayout(1, 2));
        button_panel.add(start_button);
        button_panel.add(reset_button);
        button_panel.setBounds(0, 80, 900, 20);
        new MainFrame();
    }
}