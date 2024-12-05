/**
 * PROGRAMMING 2
 * Main.java
 * 
 * Author: Adam
 * Date: 11/21/2024
 * 
 * Description:
 * This is the main entry point for the "Group-Project-personality-quiz" application.
 * The program presents a menu-driven interface allowing users to take a quiz, view past results,
 * or exit the application. It integrates the UI, quiz logic, and result analysis components.
 */

package main;

import ui.Menu;
import backend.QuizLogic;
import backend.ResultAnalyzer;

/**
 * Main class that serves as the entry point for the Personality Quiz application.
 */
public class Main {

    /**
     * The main method runs the application by displaying a menu and executing user selections.
     * 
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize the components of the quiz
        Menu menu = new Menu();                // Handles user interface //Adam Adamczyk
        QuizLogic quizLogic = new QuizLogic(); // Manages quiz questions and answers //Adam Adamczyk
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer(); // Analyzes user answers //Adam Adamczyk

        // Start the quiz application
        boolean continueRunning = true;

        while (continueRunning) {
            // Display the main menu and get user choice
            int choice = menu.displayMainMenu();

            switch (choice) {
                case 1: 
                    // Start Quiz
                    menu.displayMessage("Starting the quiz...");
                    String[] answers = quizLogic.runQuiz(); // Run the quiz and get answers
                    String result = resultAnalyzer.analyzeResults(answers); // Analyze results
                    menu.displayResult(result); // Display the results to the user
                    break;

                case 2: 
                    // View Results
                    String pastResult = quizLogic.getLastResult(); // Fetch the last result
                    if (pastResult != null) {
                        menu.displayMessage("Your last quiz result: " + pastResult);
                    } else {
                        menu.displayMessage("No past results found.");
                    }
                    break;

                case 3: 
                    // Exit
                    menu.displayMessage("Exiting the application. Thank you for playing!");
                    continueRunning = false;
                    break;

                default:
                    // Handle invalid menu options
                    menu.displayMessage("Invalid choice. Please try again.");
            }
        }
    }
}
