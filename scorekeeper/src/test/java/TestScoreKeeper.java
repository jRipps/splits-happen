import org.junit.Assert;
import org.junit.Test;

public class TestScoreKeeper {

    @Test
    public void testPerfectGame() {
        ScoreKeeper keeper = new ScoreKeeper();
        int output = keeper.processScoreLine("XXXXXXXXXXXX");
        Assert.assertEquals(300, output);
    }

    @Test
    public void testAlwaysOneShort() {
        ScoreKeeper keeper = new ScoreKeeper();
        int output = keeper.processScoreLine("9-9-9-9-9-9-9-9-9-9-");
        Assert.assertEquals(90, output);
    }

    @Test
    public void testAllSpares() {
        ScoreKeeper keeper = new ScoreKeeper();
        int output = keeper.processScoreLine("5/5/5/5/5/5/5/5/5/5/5");
        Assert.assertEquals(150, output);
    }

    @Test
    public void testRealGame() {
        ScoreKeeper keeper = new ScoreKeeper();
        int output = keeper.processScoreLine("X7/9-X-88/-6XXX81");
        Assert.assertEquals(167, output);
    }

}
