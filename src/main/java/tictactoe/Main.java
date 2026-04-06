package tictactoe;

import tictactoe.ui.Window;

import javax.swing.*;

public class Main {
    static void main() {
        SwingUtilities.invokeLater(Window::new);
    }
}