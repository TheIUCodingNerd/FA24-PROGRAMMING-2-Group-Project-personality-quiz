/*
 * Programming 2
 * QuizLogic.java
 * 
 * Author: Daniel Yozman
 * Date: 12/3/2024
 * 
 * Description:
 * This class will handle the core logic of the quiz, including loading questions,
 * running the quiz, saving and loading progress, and storing the last result.
 */

package main;

import java.util.List;
import java.util.Map;

public class QuizLogic {

    // Attributes
    private List<String> questions;
    private Map<Integer, String> userAnswers;
    private String lastResult;

    // Default constructor for QuizLogic
    public QuizLogic() {

    }

    // Gets the list of questions and returns the list
    public List<String> getQuestions() {
        return questions;
    }

    // Sets the list of questions
    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    // Gets a map of user answers and returns the map
    public Map<Integer, String> getUserAnswers() {
        return userAnswers;
    }

    // Sets the map of user answers
    public void setUserAnswers(Map<Integer, String> userAnswers) {
        this.userAnswers = userAnswers;
    }

    // Gets the last quiz result and returns the last result as a string
    public String getLastResult() {
        return lastResult;
    }

    // Sets the last result
    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    /*
     * Runs the quiz by presenting questions and collecting the answers, should
     * return an array of user's answers
     */
    public String[] runQuiz() {
        return null;
    }

    // Loads questions from Questions.json
    private void loadQuestions() {

    }

    // Saves the user's progress to a file
    private void saveProgress() {

    }

    // Loads the quiz progress from a file if it exists
    private void loadProgress() {

    }

    // Clears any saved quiz progress
    private void clearProgress() {

    }
}
