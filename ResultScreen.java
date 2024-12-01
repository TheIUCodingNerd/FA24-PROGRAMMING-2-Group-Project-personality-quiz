/*
 * @author Juliana Wall
 * @date November 2024
 * @class Programming 2
 * @projectName Personality Quiz
 * @description This class creates the result screen for the quiz, or the answer display screen
 */
package groupproject;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author julia
 */
public class ResultScreen extends JFrame {
    
    // creating method for constructing the overall UI layout of the results display
    
    public ResultScreen(String[] answers) {
        
        // setting up the frame
        
        setTitle("Personality Quiz Results");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // calculating results (need to adjust based on questions, answers chosen, and results)
        
        int score = 0;
        for (String answer : answers) {
            if (answer != null &&  !answer.isEmpty()) {
                score++;
            }
        }
        
        // setting up the panel and layout
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        
        // creating and adding the results label (text can change depending on questions)
        
        JLabel resultLabel = new JLabel("Your personality score is: " + score);
        panel.add(resultLabel);
        
        // adding the panel to the frame
        
        add(panel);
    }
}
