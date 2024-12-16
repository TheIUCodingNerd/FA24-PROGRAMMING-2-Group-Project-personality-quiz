/*
 * Programming 2
 * Question.java
 * 
 * Author: Daniel Yozman
 * Date: December 15, 2024
 */

package backend;

import java.util.List;

/* Represents a single quiz question
*  Each Question has an ID, a prompt, and a list of Answer Objects
*/

public class Question {
    private int id;
    private String text;
    private List<Answer> answers;

    // Gets the question's unique ID
    public int getId() { return id; }
    
    // Sets the question's ID
    public void setId(int id) { this.id = id; }

    // Gets the question text (prompt)
    public String getText() { return text; }
    
    // Sets the question text
    public void setText(String text) { this.text = text; }

    // Gets the list of possible answers for a question
    public List<Answer> getAnswers() { return answers; }
    
    // Sets the list of possible answers
    public void setAnswers(List<Answer> answers) { this.answers = answers; }
}
