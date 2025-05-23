package todotests;

import org.testng.annotations.Test;
import utilities.TestUtil;

public class TC_003MarkSecondTaskAsCompleted extends TodoTest {

	@Test(priority = 3)
	public void markSecondTaskAsCompleted() {
	    TestUtil.createTest("Mark Second Task as Complete");

	    // Setup: add the tasks first since this is a fresh browser
	    homePage.addTask("Buy milk");
	    homePage.addTask("Call mom");
	    homePage.addTask("Read book");

	    homePage.completeTask(1); // complete second task
	    assert homePage.isTaskCompleted(1);
	    TestUtil.logPass("Second task marked as completed");
	}
}

