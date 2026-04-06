package ui.component;

import javax.swing.*;

public class Button extends JButton {
    public int row;
    public int col;

    public Button(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }
}
