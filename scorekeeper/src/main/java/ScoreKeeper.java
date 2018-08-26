import java.util.ArrayList;

/**
 * A class that will calculate the total score of a game of bowling represented by a string
 *
 */
public class ScoreKeeper {

    /**
     * returns the total score fromt he string representign a game of bowling using the following rules:
     * "X" indicates a strike,
     * "/" indicates a spare,
     * "-" indicates a miss,
     * and a number indicates the number of pins knocked down in the roll
     */
    public int processScoreLine(String line) {
        ArrayList<Frame> frames = new ArrayList<>();
        char[] lineChars = line.toLowerCase().toCharArray();
        int totalScore = 0;

        for(int i = 0; i < lineChars.length; i++) {
            //if this frame is a spare or a single bonus roll
            if(lineChars[i] == 'x' || lineChars.length-1 == i) {
                frames.add(new Frame(frames,frames.size(), lineChars[i]));
            } else {
                frames.add(new Frame(frames,frames.size(), lineChars[i++], lineChars[i]));

            }
        }

        for(int i = 0; i < 10; i++) {
            totalScore += frames.get(i).getFrameScore();
        }

        return totalScore;
    }
}
