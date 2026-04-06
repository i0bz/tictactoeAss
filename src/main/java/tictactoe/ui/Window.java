package tictactoe.ui;

import javax.swing.*;
import java.awt.*;

public class Window {
    private final JFrame frame = new JFrame();
    public final Dimension size = new Dimension(500,500);

    private final GameView gameView = new GameView();
    private final Titlebar titlebar = new Titlebar();


    public Window() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(size);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        frame.add(titlebar.getPanel(), BorderLayout.NORTH);
        frame.add(gameView.getPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
