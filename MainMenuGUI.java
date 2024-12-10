import javax.swing.*;
import java.awt.*;

/**
 * MainMenu Class
 * This class creates the main menu for the quiz application.
 * Created by Adam Adamczyk
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        // Set the title, size, and default behavior of the main menu window
        setTitle("Personality Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a panel with a grid layout for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // Create a "Start Quiz" button
        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(e -> {
            // Open the QuestionScreen and close the current window
            new QuestionScreen().setVisible(true);
            dispose(); // Dispose of the current frame
        });

        // Create an "Exit" button to close the application
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0)); // Exit the program

        // Add the buttons to the panel
        panel.add(startButton);
        panel.add(exitButton);

        // Add the panel to the main frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
