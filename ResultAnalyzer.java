/*
 * Programming 2
 * ResultAnalyzer.java
 * 
 * Author: Daniel Yozman
 * Date: December 15, 2024
 * 
 * Description:
 * This class will analyze the user's answers to the quiz and give the resulting
 * personality type.
 */

package backend;

import java.util.List;
import java.util.Map;

public class ResultAnalyzer {

    // Default Constructor
    public ResultAnalyzer() {
    }

    // Analyzes the user's answers to calculate their alignment
    public String analyzeResults(List<Question> questions, Map<Integer, String> userAnswers) {
        if (questions == null || questions.isEmpty() || userAnswers == null || userAnswers.isEmpty()) {
            return "No answers provided.";
        }

        // Initialize lawChaosTotal and goodEvilTotal
        int lawChaosTotal = 0;
        int goodEvilTotal = 0;

        // Sum the lawChaos and goodEvil values based on user's answers
        for (int i = 0; i < questions.size(); i++) {
            if (userAnswers.containsKey(i)) {
                String answerIndexStr = userAnswers.get(i);
                int answerIndex;
                try {
                    answerIndex = Integer.parseInt(answerIndexStr);
                } catch (NumberFormatException e) {
                    // Skip if the answer index isn't a valid integer
                    continue;
                }

                Question q = questions.get(i);
                if (answerIndex >= 0 && answerIndex < q.getAnswers().size()) {
                    Answer chosenAnswer = q.getAnswers().get(answerIndex);
                    lawChaosTotal += chosenAnswer.getLawChaos();
                    goodEvilTotal += chosenAnswer.getGoodEvil();
                }
            }
        }
        // Determine the user's final alignment string from the two axis totals
        return determineAlignment(lawChaosTotal, goodEvilTotal);
    }

    /* Determines the alignment based on lawChaosTotal and goodEvilTotal
    *  Negative lawChaos = Lawful, 0 = Neutral, Postiive = Chaotic
    *  Negative goodEvil = Evil, 0 = Neutral, Positive = Good
    *  If both axes are neutral, returns True Neutral
    */
    private String determineAlignment(int lawChaosTotal, int goodEvilTotal) {
        String lawChaosAlignment;
        if (lawChaosTotal < 0) {
            lawChaosAlignment = "Lawful";
        } else if (lawChaosTotal > 0) {
            lawChaosAlignment = "Chaotic";
        } else {
            lawChaosAlignment = "Neutral";
        }

        String goodEvilAlignment;
        if (goodEvilTotal < 0) {
            goodEvilAlignment = "Evil";
        } else if (goodEvilTotal > 0) {
            goodEvilAlignment = "Good";
        } else {
            goodEvilAlignment = "Neutral";
        }
        // If both are neutral the user is True Neutral
        if (lawChaosAlignment.equals("Neutral") && goodEvilAlignment.equals("Neutral")) {
            return "True Neutral";
        } else {
            return lawChaosAlignment + " " + goodEvilAlignment;
        }
    }
}
