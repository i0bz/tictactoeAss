package ui;

import javax.swing.*;
import java.awt.*;

public class Window {
    private final JFrame frame = new JFrame();
    public final Dimension size = new Dimension(500,500);

    private final Titlebar titlebar = new Titlebar();
    private final JPanel turn = new JPanel();

    private final JLabel turnLabel = new JLabel();
    private final GameView gameView = new GameView(titlebar, turnLabel);


    public Window() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(size);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        turn.add(turnLabel);

        frame.add(titlebar.getPanel(), BorderLayout.NORTH);
        frame.add(gameView.getPanel(), BorderLayout.CENTER);
        frame.add(turn, BorderLayout.SOUTH);



        frame.setVisible(true);


        gameView.getPlayerNames();
    }

}
