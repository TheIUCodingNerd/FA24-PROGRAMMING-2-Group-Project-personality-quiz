/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author julia
 */
public class ResultScreen extends JFrame {
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
