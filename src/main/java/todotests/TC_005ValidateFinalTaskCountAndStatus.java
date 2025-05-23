package todotests;

import org.testng.annotations.Test;
import utilities.TestUtil;

public class TC_005ValidateFinalTaskCountAndStatus extends TodoTest {

    @Test(priority = 5)
    public void validateFinalTaskCountAndStatus() {
        TestUtil.createTest("Validate UI Status After Operations");

        
        homePage.addTask("Buy milk");
	    homePage.addTask("Call mom");
	    homePage.addTask("Read book");
        homePage.completeTask(1);   // Mark Task B as completed
        homePage.deleteTask(0);     // Delete Task A

        
        int expectedCount = 2;
        int actualCount = homePage.getTaskCount();
        assert actualCount == expectedCount : "Expected task count: " + expectedCount + ", but got: " + actualCount;

        TestUtil.logPass("Task count validated successfully as 2");
    }
}
