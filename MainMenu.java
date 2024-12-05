/*
 * @author Juliana Wall
 * @date November 2024
 * @class Programming 2
 * @projectName Personality Quiz
 * @description This class creates the main menu for the quiz, or the start screen
 */
package groupproject;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

/**
 *
 * @author Juliana Wall
 */
public class MainMenu extends JFrame {
    
    // creating method for constructing the overall UI layout of the main menu
    
    public MainMenu() {
        
        // setting up the frame
        
        setTitle("Personality Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        // setting up the panel and layout
        
        JPanel panel = new JPanel(); //Adam Adamczyk
        panel.setLayout(new GridLayout(2, 1)); //Adam Adamczyk
        
        // creating and adding the start button
        
        JButton startButton = new JButton("Start Quiz"); //Adam Adamczyk
        startButton.addActionListener(new ActionListener() { //Adam Adamczyk
            public void actionPerformed(ActionEvent e) {
                
                // opening the question screen
                
                new QuestionScreen().setVisible(true); // Adam Adamczyk: Changed to directly call the constructor and make the screen visible //Adam Adamczyk
                dispose(); // Adam Adamczyk: Added dispose to close the current frame after opening QuestionScreen //Adam Adamczyk
            }
        });
        panel.add(startButton); 
        
        // adding an additional button for exiting the application
        JButton exitButton = new JButton("Exit"); // Adam Adamczyk: Added an exit button //Adam Adamczyk
        exitButton.addActionListener(e -> System.exit(0)); // Adam Adamczyk: Added action listener to exit the application
        panel.add(exitButton); // Adam Adamczyk: Added exit button to the panel
        
        // adding the panel to the frame
        
        add(panel);
    }
    
    // calling the main menu screen to appear
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true); //Adam Adamczyk
        });
    }
}
