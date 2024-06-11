import controller.MainController;
import dao.DatabaseConnection;
import view.MainView;
import view.ViewEnum;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("M-Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(800, 600);

        // init database
        DatabaseConnection.getInstance();

        // Create MainView
        MainView mainView = new MainView();
        MainController.getInstance().show(ViewEnum.HOME, null);

        // Add MainView to the frame
        frame.add(mainView.getPanel());

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show the frame
        frame.setVisible(true);
    }
}
