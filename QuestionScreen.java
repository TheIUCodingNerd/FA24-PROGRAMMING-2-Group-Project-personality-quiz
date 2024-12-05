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
 * @author Juliana Wall //Adam Adamczyk
 */
public class QuestionScreen extends JFrame {
    private int currentQuestionIndex = 0;
    private String[] questions = {
        "Question 1?", //Adam Adamczyk: Added placeholder question text
        "Question 2?", //Adam Adamczyk: Added placeholder question text
        "Question 3?"  //Adam Adamczyk: Added placeholder question text
    };
    private String[] answers = new String[questions.length]; //Adam Adamczyk
    
    // Creating method for constructing the overall UI layout of the question screens
    
    public QuestionScreen() {
        
        // Setting up the frame
        
        setTitle("Personality Quiz - Question");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Setting up the panel and layout
        
        JPanel panel = new JPanel(); //Adam Adamczyk
        panel.setLayout(new BorderLayout()); //Adam Adamczyk
        
        // Creating question label
        
        JLabel questionLabel = new JLabel(questions[currentQuestionIndex]); //Adam Adamczyk: Dynamically shows the current question
        panel.add(questionLabel, BorderLayout.NORTH);
        
        // Creating text field for answer
        
        JTextField answerField = new JTextField(); //Adam Adamczyk
        panel.add(answerField, BorderLayout.CENTER);
        
        // Creating next button
        
        JButton nextButton = new JButton("Next"); //Adam Adamczyk
        nextButton.addActionListener(new ActionListener() { //Adam Adamczyk
            public void actionPerformed(ActionEvent e) {
                answers[currentQuestionIndex] = answerField.getText(); //Adam Adamczyk: Saves user input to the answers array
                currentQuestionIndex++; //Adam Adamczyk: Advances to the next question
                if (currentQuestionIndex < questions.length) {
                    questionLabel.setText(questions[currentQuestionIndex]); //Adam Adamczyk: Updates the question text
                    answerField.setText(""); //Adam Adamczyk: Clears the text field for the next answer
                } else {
                    
                    // End of questions, showing results
                    
                    new ResultScreen(answers).setVisible(true); //Adam Adamczyk: Opens the result screen
                    dispose(); //Adam Adamczyk: Closes the question screen
                }
            }
        });
        panel.add(nextButton, BorderLayout.SOUTH);
        
        // Adding panel to frame
        
        add(panel); //Adam Adamczyk
    }
}
