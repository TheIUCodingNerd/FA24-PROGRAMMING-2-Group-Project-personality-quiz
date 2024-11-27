/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class MainMenu extends JFrame{
    public MainMenu() {
        //setting up the frame
        setTitle("Personality Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //setting up the panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        
        //creating and adding the start button
        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //opening the question screen
                new QuestionScreen().setVisible(true);
                dispose();
            }
        });
        panel.add(startButton);
        
        ////adding the panel to the frame
        add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
}
