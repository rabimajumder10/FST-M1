 
 
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class Activity9 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void completeLesson() throws InterruptedException {       
        WebElement allCoursesMenu = driver.findElement(By.linkText("All Courses"));
        allCoursesMenu.click();
        Thread.sleep(2000); 
        
        List<WebElement> courses = driver.findElements(By.cssSelector("div.ld_course_grid"));
        Assert.assertTrue(courses.size() > 0, "No courses found!");
        courses.get(0).click();
        Thread.sleep(2000);

        List<WebElement> lessons = driver.findElements(By.cssSelector(".ld-item-title a"));
        Assert.assertTrue(lessons.size() > 0, "No lessons found!");
        lessons.get(0).click();
        Thread.sleep(2000);

        WebElement courseTitle = driver.findElement(By.cssSelector(".ld-course-title"));
        System.out.println("Course title: " + courseTitle.getText());
        Assert.assertTrue(courseTitle.isDisplayed(), "Course title not displayed.");
       
        List<WebElement> markCompleteBtns = driver.findElements(By.cssSelector(".ld-mark-complete-button"));
        if (!markCompleteBtns.isEmpty()) {
            WebElement markCompleteBtn = markCompleteBtns.get(0);
            if (markCompleteBtn.isDisplayed() && markCompleteBtn.isEnabled()) {
                markCompleteBtn.click();
                System.out.println("Clicked 'Mark Complete' button.");
            }
        } else {
            System.out.println("'Mark Complete' button not found on this lesson.");
        }
    }

    @AfterClass
    public void tearDown() {        
        if (driver != null) {
            driver.quit();
        }
    }
}