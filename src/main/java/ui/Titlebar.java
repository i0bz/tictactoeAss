package ui;


import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Titlebar {
    private JPanel panel = new JPanel(new GridLayout(1,2));
    JLabel player1 = new JLabel(" ");
    JLabel player2 = new JLabel(" ");

    CompoundBorder border = new CompoundBorder(new LineBorder(Color.GRAY, 1, true), new EmptyBorder(5,5,5,5));


    Titlebar() {
        player1.setHorizontalAlignment(SwingConstants.CENTER);
        player1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        player2.setHorizontalAlignment(SwingConstants.CENTER);
        player2.setFont(new Font("Segoe UI", Font.BOLD, 15));

        panel.add(player1);
        panel.add(player2);

        panel.setBorder(new TitledBorder(border, "Players"));
    }

    public JPanel getPanel() {
        return panel;
    }
}
