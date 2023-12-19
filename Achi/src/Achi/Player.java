package Achi;
import static Achi.Achi.*;

class Player {
    CELL symbol;
    String name;
    int score;
    int wins;

    public Player(CELL symbol) {
        this.symbol = symbol;
        this.score = 0;
        this.wins = 0;

        if (symbol == CELL.X) {
            this.name = "Player X";
        } else {
            this.name = "Player O";
        }
    }
}