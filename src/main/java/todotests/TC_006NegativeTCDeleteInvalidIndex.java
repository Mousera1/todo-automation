package todotests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestUtil;

public class TC_006NegativeTCDeleteInvalidIndex extends TodoTest {

   
    @Test(priority = 6)
    public void deleteNonExistentTask() {
        TestUtil.createTest("Negative: Delete Non-existent Task");

        int invalidIndex = 1000; 

        if (invalidIndex >= homePage.getTaskCount()) {
            TestUtil.logFailAndFailTest(driver, "Invalid index provided: " + invalidIndex + ". No such task exists.");
        } else {
            homePage.deleteTask(invalidIndex);
            TestUtil.logPass("Deleted task at index " + invalidIndex);
        }
    
    }}
