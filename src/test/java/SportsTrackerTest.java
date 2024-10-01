import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportsTrackerTest {

    @Test
    public void testLogActivity() {
        SportsTracker tracker = new SportsTracker();
        tracker.logActivity("Running", 30);
        assertEquals(1, tracker.getActivities().size());
        assertEquals("Running", tracker.getActivities().get(0).name);
        assertEquals(30, tracker.getActivities().get(0).duration);
    }

    @Test
    public void testCalculateTotalTime() {
        SportsTracker tracker = new SportsTracker();
        tracker.logActivity("Running", 30);
        tracker.logActivity("Swimming", 45);
        assertEquals(75, tracker.calculateTotalTime());
    }

    @Test
    public void testViewActivities() {
        SportsTracker tracker = new SportsTracker();
        tracker.logActivity("Running", 30);
        tracker.logActivity("Swimming", 45);
        tracker.viewActivities();
        // This test is more for manual verification as it prints to console
    }
}