import view.MainView;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("M-Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(800, 600);

        // Add MainView to the frame
        frame.add(MainView.getInstance().getPanel());

        // Center the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
