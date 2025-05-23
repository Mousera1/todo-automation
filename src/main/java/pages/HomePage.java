package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = ".new-todo")
    WebElement inputBox;

    @FindBy(css = ".todo-list li")
    List<WebElement> taskList;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Add a new task
    public void addTask(String taskName) {
        inputBox.sendKeys(taskName);
        inputBox.sendKeys(Keys.ENTER);
    }

    // Mark task as completed by index (0-based)
    public void completeTask(int index) {
        WebElement checkbox = taskList.get(index).findElement(By.cssSelector("input.toggle"));
        checkbox.click();
    }

    // Delete task by index (requires hover)
    public void deleteTask(int index) {
        Actions actions = new Actions(driver);
        WebElement task = taskList.get(index);
        actions.moveToElement(task).perform();
        task.findElement(By.cssSelector("button.destroy")).click();
    }

    // Check if task is marked as completed
    public boolean isTaskCompleted(int index) {
        String className = taskList.get(index).getAttribute("class");
        return className.contains("completed");
    }

    // Get current number of tasks displayed
    public int getTaskCount() {
        return taskList.size();
    }
}
