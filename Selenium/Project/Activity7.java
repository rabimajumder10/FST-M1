   import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class Activity7 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void countCourses() throws InterruptedException {
        WebElement allCoursesMenu = driver.findElement(By.linkText("All Courses"));
        allCoursesMenu.click();
        Thread.sleep(2000);
        List<WebElement> courses = driver.findElements(By.cssSelector("div.ld_course_grid"));
        System.out.println("Total number of courses: " + courses.size());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

 