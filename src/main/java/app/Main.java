package app;

import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import view.LoginFrame;

public class Main {

    public static void main(String[] args) {
        try {
            // L&F bawaan Java (Metal), bukan Nimbus
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Color ungu = new Color(51, 6, 148);

        UIManager.put("MenuBar.background", new ColorUIResource(ungu));
        UIManager.put("Menu.background", new ColorUIResource(ungu));
        UIManager.put("Menu.foreground", new ColorUIResource(Color.WHITE));
        UIManager.put("Menu.selectionBackground", new ColorUIResource(new Color(90, 50, 190)));
        UIManager.put("Menu.selectionForeground", new ColorUIResource(Color.WHITE));
        UIManager.put("Menu.disabledForeground", new ColorUIResource(new Color(170, 150, 220)));
        UIManager.put("MenuItem.disabledForeground", new ColorUIResource(new Color(150, 150, 150)));

        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}