package tictactoe.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameView {
    private final int rows = 3;
    private final int cols = 3;
    private final JPanel panel = new JPanel(new GridLayout(rows, cols, 0, 0));
    private ArrayList<JButton> buttons = new ArrayList<>(rows * cols);
    private final JButton test = new JButton(" ");



    GameView() {
        displayBtns();
    }


    private void displayBtns() {
        for (int i = 0; i < (rows * cols); i++) {
            buttons.add(new JButton());
        }

        buttons.forEach(panel::add);
    }









    public JPanel getPanel() {
        return panel;
    }

}
