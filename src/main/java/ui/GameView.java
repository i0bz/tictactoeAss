package ui;

import core.ActionResult;
import core.Board;
import ui.component.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameView {
    private final int ROWS = 3;
    private final int COLS = 3;
    private final JPanel panel = new JPanel(new GridLayout(ROWS, COLS, 0, 0));
    private final ArrayList<Button> buttons = new ArrayList<>(ROWS * COLS);

    private final String[] players = new String[2];

    private JLabel turnLabel;
    private int index = 0;


    private final Titlebar titlebar;
    private final Board tictactoeGame = new Board();


    GameView(Titlebar titlebar, JLabel turnLabel) {
        this.turnLabel = turnLabel;
        this.titlebar = titlebar;
        initializeBtns();
        eventHandlers();
    }


    private void initializeBtns() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons.add(new Button(i, j));
            }
        }
        buttons.forEach(btn -> btn.setFont(new Font("Segoe UI", Font.BOLD, 13)));
        buttons.forEach(panel::add);
    }

    void getPlayerNames() {
        players[0] = JOptionPane.showInputDialog(null, "Enter Player 1:", "Input Names", JOptionPane.QUESTION_MESSAGE);
        players[1] = JOptionPane.showInputDialog(null, "Enter Player 2: ", "Input Names", JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < 2; i++) if (players[i] == null || players[i].trim().isBlank()) players[i] = "Anonymous";
        titlebar.player1.setText(players[0]);
        titlebar.player2.setText(players[1]);
        turnLabel.setText(players[0]);
    }


    private void eventHandlers() {
        for (Button btn : buttons) {
            btn.addActionListener(e -> {
                String text = "";
                index = (index + 1) % 2;
                turnLabel.setText(players[index]);

                switch (tictactoeGame.currentPlayer) {
                    case ONE -> text = "X";
                    case TWO -> text = "O";
                }


                Button button = (Button) e.getSource();
                int row = ((Button)e.getSource()).row;
                int col = ((Button)e.getSource()).col;

                switch (tictactoeGame.move(row, col)) {
                    case SUCCESS -> button.setText(text);
                    case CELL_OCCUPIED -> JOptionPane.showMessageDialog(null, "Cell is already occupied!!!");
                    case DRAW -> {
                        button.setText(text);
                        JOptionPane.showMessageDialog(null, "Draw");
                        restartGame();
                    }
                    case PLAYER_ONE_WIN -> {
                        button.setText(text);
                        showWinner(ActionResult.PLAYER_ONE_WIN);
                    }
                    case PLAYER_TWO_WIN -> {
                        button.setText(text);
                        showWinner(ActionResult.PLAYER_TWO_WIN);
                    }
                }

            });


        }
    }

    private void restartGame() {
        int response = JOptionPane.showConfirmDialog(null,"Wanna Play Again?", "Retry",  JOptionPane.YES_NO_OPTION);
        if (response != JOptionPane.YES_OPTION) System.exit(0);
        tictactoeGame.reset();
        getPlayerNames();
        buttons.forEach(btn -> btn.setText(""));
    }




    private void showWinner(ActionResult result) {
        switch (result) {
            case PLAYER_ONE_WIN -> JOptionPane.showMessageDialog(null, "Winner: " + players[0]);
            case PLAYER_TWO_WIN -> JOptionPane.showMessageDialog(null, "Winner: " + players[1]);
        }
        restartGame();
    }


    public JPanel getPanel() {
        return panel;
    }

}
