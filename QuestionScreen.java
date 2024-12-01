/*
 * @author Juliana Wall
 * @date November 2024
 * @class Programming 2
 * @projectName Personality Quiz
 * @description This class creates the layout for the questions appearing on the screen
 */
package groupproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author julia
 */
public class QuestionScreen extends JFrame {
    private int currentQuestionIndex = 0;
    private String[] questions = {
        " ",
        " ",
        " ",
    };
    private String[] answers = new String[questions.length];
    
    // creating method for constructing the overall UI layout of the question screens
    
    public QuestionScreen() {
        
        // setting up the frame
        
        setTitle("Personality Quiz - Question");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // setting up the panel and layout
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // creating question label
        
        JLabel questionLabel = new JLabel(questions[currentQuestionIndex]);
        panel.add(questionLabel, BorderLayout.NORTH);
        
        // creating text field for answer
        
        JTextField answerField = new JTextField();
        panel.add(answerField, BorderLayout.CENTER);
        
        // creating next button
        
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answers[currentQuestionIndex] = answerField.getText();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    questionLabel.setText(questions[currentQuestionIndex]);
                    answerField.setText("");
                } else {
                    
                    // end of questions, showing results
                    
                    new ResultScreen(answers).setVisible(true);
                    dispose();
                }
            }
        });
        panel.add(nextButton, BorderLayout.SOUTH);
        
        // adding panel to frame
        
        add(panel);
    }
}
