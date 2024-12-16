/*
 * Programming 2
 * QuizLogic.java
 * 
 * Author: Daniel Yozman
 * Date: December 15, 2024
 *
 * Description:
 * This class will handle the core logic of the quiz, including loading questions,
 * running the quiz, saving and loading progress, and storing the last result.
 */

package backend;

import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class QuizLogic {
    private List<Question> questions;
    private Map<Integer, String> userAnswers;
    private String lastResult;

    // File names that the Quesitons and progress will be saved to
    private static final String QUESTIONS_FILE = "Questions.json";
    private static final String PROGRESS_FILE = "progress.json";

    /* Default constructor that initializes empty data structures and
    *  attempts to load questions from the file
    */
    public QuizLogic() {
        this.questions = new ArrayList<>();
        this.userAnswers = new HashMap<>();
        this.lastResult = null;
        loadQuestions();
    }

    /* Gets the text of all of the loaded questions as a list of strings
    *  Returns a list of question texts
    */
    public List<String> getQuestions() {
        List<String> questionTexts = new ArrayList<>();
        for (Question q : questions) {
            questionTexts.add(q.getText());
        }
        return questionTexts;
    }

    /* Gets user answers map, where the key is the question index
    *  and the value is the selected answers index as a String
    *  Returns a map of user answers
    */
    public Map<Integer, String> getUserAnswers() {
        return userAnswers;
    }

    /* Sets the user answers map. Can be used to restore previously
    *  saved answers or to set answers
    */
    public void setUserAnswers(Map<Integer, String> userAnswers) {
        this.userAnswers = userAnswers;
    }

    /* Gets the last result of the quiz (alignment) that was calculated 
    *  Returns the last quiz result as a string
    */
    public String getLastResult() {
        return lastResult;
    }

    /* Sets the last quiz result, should usually be called after analyzing
    *  results.
    */
    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    /* Gets the list of Question objects. 
    *  Can be used for direct access to the question data
    *  Returns a list of question objects
    */
    public List<Question> getQuestionsObject() {
        return questions;
    }
    
    /* Runs the quiz logic by returning the chosen answers' text
    *  (This doesn't handl input, the UI should set userAnswers first)
    *  Returns an array of chosen answer texts in order of the questions
    */
    public String[] runQuiz() {
        if (questions.isEmpty()) {
            return new String[0];
        }

        String[] chosenAnswers = new String[questions.size()];
        for (int i = 0; i < questions.size(); i++) {
            if (userAnswers.containsKey(i)) {
                int chosenIndex = Integer.parseInt(userAnswers.get(i));
                if (chosenIndex >= 0 && chosenIndex < questions.get(i).getAnswers().size()) {
                    chosenAnswers[i] = questions.get(i).getAnswers().get(chosenIndex).getText();
                } else {
                    chosenAnswers[i] = "";
                }
            } else {
                chosenAnswers[i] = "";
            }
        }
        return chosenAnswers;
    }

    /* Loads questions from the Questions.json file into the "questions" list
    *  Parses the JSON using Gson
    */
    private void loadQuestions() {
        try (Reader reader = new FileReader(QUESTIONS_FILE)) {
            Gson gson = new Gson();
            QuestionData data = gson.fromJson(reader, QuestionData.class);
            if (data != null && data.getQuestions() != null) {
                this.questions = data.getQuestions();
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.questions = Collections.emptyList();
        }
    }

    /* Saves the current progress of the quiz, including answers and last
    *  result to a JSON file "progress.json"
    */
    public void saveProgress() {
        Map<String, Object> progressData = new HashMap<>();
        progressData.put("lastResult", lastResult);
        progressData.put("userAnswers", userAnswers);

        Gson gson = new Gson();
        try (Writer writer = new FileWriter(PROGRESS_FILE)) {
            gson.toJson(progressData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Loads any previously saved progress from "progress.json"
    *  Restores userAnswers and lastResult if they are available
    */
    public void loadProgress() {
        File file = new File(PROGRESS_FILE);
        if (!file.exists()) {
            return;
        }

        Gson gson = new Gson();
        try (Reader reader = new FileReader(file)) {
            Map<String, Object> progressData = gson.fromJson(reader, new TypeToken<Map<String, Object>>(){}.getType());
            if (progressData != null) {
                if (progressData.get("lastResult") instanceof String) {
                    this.lastResult = (String) progressData.get("lastResult");
                }
                if (progressData.get("userAnswers") instanceof Map) {
                    Map<String, String> loadedAnswers = (Map<String, String>) progressData.get("userAnswers");
                    Map<Integer, String> restoredAnswers = new HashMap<>();
                    for (Map.Entry<String, String> entry : loadedAnswers.entrySet()) {
                        restoredAnswers.put(Integer.parseInt(entry.getKey()), entry.getValue());
                    }
                    this.userAnswers = restoredAnswers;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Clears any saved quiz progress by simply deleting the "progress.json"
    *  file and resetting any other active data
    */
    public void clearProgress() {
        File file = new File(PROGRESS_FILE);
        if (file.exists()) {
            file.delete();
        }
        userAnswers.clear();
        lastResult = null;
    }
}
