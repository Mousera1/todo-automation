package todotests;

import org.testng.annotations.Test;
import utilities.TestUtil;

public class TC_004DeleteFirstTask extends TodoTest {

    @Test(priority = 4)
    public void deleteFirstTask() {
        TestUtil.createTest("Delete First Task");

        // Setup: Add tasks first
        homePage.addTask("Buy milk");
	    homePage.addTask("Call mom");
	    homePage.addTask("Read book");

        //Now delete the first task
        homePage.deleteTask(0);

        TestUtil.logPass("Deleted the first task");
    }
}
