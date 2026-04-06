import ui.Window;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Main {
    static void main() {

        FlatLightLaf.setup();
        UIManager.put("Button.arc", 0);
        SwingUtilities.invokeLater(Window::new);
    }
}