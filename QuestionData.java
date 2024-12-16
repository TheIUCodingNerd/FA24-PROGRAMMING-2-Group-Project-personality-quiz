/*
 * Programming 2
 * QuestionData.java
 * 
 * Author: Daniel Yozman
 * Date: December 15, 2024
 */

package backend;

import java.util.List;

/* Container class that holds a list of Question objects
*  Used by Gson to parse the JSON file structure where the
*  root element contains an array of questions
*/

public class QuestionData {
    // A list of questions parsed from JSON file
    private List<Question> questions;

    // Gets the list of parsed Question objects and returns the list of objects
    public List<Question> getQuestions() {
        return questions;
    }
    
    // Sets the list of Question objects
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
