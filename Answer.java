/*
 * Programming 2
 * Answer.java
 * 
 * Author: Daniel Yozman
 * Date: December 15, 2024
 */

package backend;

public class Answer {
    private String text;
    private int lawChaos;
    private int goodEvil;

    // Gets the answer text, returns the answer text as a String
    public String getText() { return text; }
    
    // Sets the answer text
    public void setText(String text) { this.text = text; }

    /* Gets the lawChaos score
    *  Negative values -> Lawful, Positive -> Chaotic, 0 -> Neutral
    *  Returns lawChaos score
    */
    public int getLawChaos() { return lawChaos; }
    
    // Sets the lawChaos score
    public void setLawChaos(int lawChaos) { this.lawChaos = lawChaos; }

    /* Gets the goodEvilScore
    * Negative values -> Evil, Positive -> Good, 0 -> Neutral
    * Returns goodEvil score
    */
    public int getGoodEvil() { return goodEvil; }
    
    // Sets the goodEvil score
    public void setGoodEvil(int goodEvil) { this.goodEvil = goodEvil; }
}
