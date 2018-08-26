
import java.util.List;

/**
 * Represents a single frame in a bowling score
 *
 */
public class Frame {
    /** the outcome of the first roll of this frame */
    private int rollOne = 0;
    /** the outcome of the second roll of this frame */
    private int rollTwo = 0;
    /** list of all frames for this game */
    private List<Frame> frameList;
    /** index for this frame in the list of all frames */
    private int index;
    /** total pin count. */
    private static final int PIN_COUNT = 10;

    /**
     * Constructs a new frame
     *
     * @param frameList List<Frame>
     * @param index int
     * @param frameChars char[]
     */
    public Frame(List<Frame> frameList, int index, char ... frameChars) {
        parseFrameLine(frameChars);
        this.frameList = frameList;
        this.index = index;
    }

    /**
     * Parses the given array oof characters into one or two rolls
     *
     * @param frameChars char[]
     */
    private void parseFrameLine(char[] frameChars) {
        //first roll
        if(frameChars[0] == 'x') {
            this.rollOne = PIN_COUNT;
            return;
        } else if(Character.isDigit(frameChars[0])) {
            this.rollOne = frameChars[0] - '0';
        }
        if(frameChars.length == 2) {
            //second roll
            if (frameChars[1] == '/') {
                this.rollTwo = PIN_COUNT - rollOne;
            } else if (Character.isDigit(frameChars[1])) {
                this.rollTwo = frameChars[1] - '0';
            }
        }
    }

    /**
     * getter for roll one
     *
     * @return int
     */
    public int getRollOne() {
        return this.rollOne;
    }

    /**
     * getter for roll two, in the case of a strike roll two is in the next frame
     * (for scoring purposes)
     *
     * @return int
     */
    public int getRollTwo() {
        if (this.rollOne == PIN_COUNT) {
            //first roll was a strike so next roll is in next frame
            return this.frameList.get(this.index+1).getRollOne();
        } else {
            return this.rollTwo;
        }
    }

    /**
     * Calculates and returns this frames total score
     *
     * @return int
     */
    public int getFrameScore() {
        int totalFrameScore;
        if(this.rollOne == PIN_COUNT) {
            Frame nextFrame = this.frameList.get(this.index+1);
            totalFrameScore = PIN_COUNT + nextFrame.getRollOne() + nextFrame.getRollTwo();
        } else if(( totalFrameScore = (this.rollOne + this.rollTwo)) == PIN_COUNT) {
            Frame nextFrame = this.frameList.get(this.index+1);
            totalFrameScore = totalFrameScore + nextFrame.getRollOne();
        }
        return totalFrameScore;
    }
}
